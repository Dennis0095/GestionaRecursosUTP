package DAOS;

import ConexionBD.ConexionDB;
import DTOS.Anuncios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnunciosDAO {
    public static PreparedStatement pstm=null; // PreparedStatement = realizar consulta
    public static ResultSet res=null;          // ResultSet=almacena resultado de la consulta a la DB
    public static ConexionDB con = ConexionDB.getInstance(); // establece una instancia de conexion a la BD
    
    public static final String SQL_UPDATE="update anuncios set titulo=?,noticia=?,fecha=?";//definir para modificar
    
    public Boolean insertar(Anuncios a){
        boolean resultado=false;
        String SQL_INSERT="insert into anuncios(titulo,noticia,fecha)values(?,?,?)" ;
        try{
            pstm=con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, a.getTitulo());
            pstm.setString(2, a.getNoticia());
            pstm.setString(3, a.getFecha());
            
            if(pstm.executeUpdate()>0){ //se usa el update cuando se modifica el estado del registro de la DB (crear,modificar o eliminar), se usa query cuando se hace consulta
                resultado=true;            //result es true cuando se ejecuta la transaccion
            }
        }catch (Exception e){
            System.out.println("Error al insertar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public List jalarNoticia(String busqueda){
        String SQL_NOTICIA="select * from anuncios where titulo LIKE '%"+busqueda+"%' or noticia LIKE'%"+busqueda+"%' or fecha LIKE'%"+busqueda+"%'";
        List<Anuncios>noticia =new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_NOTICIA);
            res=pstm.executeQuery();
            while(res.next()){
                Anuncios comunicado=new Anuncios();
                comunicado.setId(res.getString(1));
                comunicado.setTitulo(res.getString(2));
                comunicado.setNoticia(res.getString(3));
                comunicado.setFecha(res.getString(4));
                noticia.add(comunicado);
            }
        }
        catch(Exception e){
            System.out.println("Error al consultar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return noticia;
    }
    
    public void cerrarConexion() {
        try{
            if(res!=null)res.close();   //en este orden se cierra
            if(pstm!=null)pstm.close();
            if(con!=null)con.cerrarConexion();
        }catch (Exception e){
            System.out.println("Error al cerrar conexion"+e.getMessage());
            e.printStackTrace();
        }
    }
}