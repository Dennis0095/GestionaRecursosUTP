package DAOS;

import ConexionBD.ConexionDB;
import DTOS.Incidencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO {
    private static PreparedStatement pstm=null; // PreparedStatement = realizar consulta
    private static ResultSet res=null;          // ResultSet=almacena resultado de la consulta a la DB
    private static final ConexionDB con = ConexionDB.getInstance(); // establece una instancia de conexion a la BD
    
    public Boolean registrar(Incidencia t) {
        String SQL_INSERT="insert into incidencias(fecha,usuario,nombreHost,descripcion)values(?,?,?,?)" ;
        boolean resultado=false;
        try{
            pstm=con.getConnection().prepareStatement(SQL_INSERT); //abre conexion para datos
            pstm.setString(1,t.getFecha());
            pstm.setString(2,t.getUsuario());    //obtiene los datos ingresados en los formularios a la clase, aqui recien se define el tipo de dato
            pstm.setString(3,t.getNombreHost());
            pstm.setString(4,t.getDescripcion());
                        
            if(pstm.executeUpdate()>0){ //se usa el update cuando se modifica el estado del registro de la DB 
                resultado=true;            //result es true cuando se ejecuta la transaccion
            }
        }
        catch (Exception e){
            System.out.println("Error al insertar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
     
    //metodo que busca las incidencias de la DB
    public List BuscarEvento(String busqueda){
        String SQL_BUSCAEVENTO="select * from incidencias where fecha LIKE '%"+busqueda+"%' or usuario LIKE '%"+busqueda+"%' or nombreHost LIKE '%"+busqueda+"%'";
        List<Incidencia>ocurrencia=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_BUSCAEVENTO);
            res=pstm.executeQuery();
            while(res.next()){
                Incidencia evento = new Incidencia();
                evento.setId(res.getString(1));
                evento.setFecha(res.getString(2));
                evento.setUsuario(res.getString(3));
                evento.setNombreHost(res.getString(4));
                evento.setDescripcion(res.getString(5));
                ocurrencia.add(evento);
            }
        }
        catch (Exception e) {
            System.out.println("Error al consultar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return ocurrencia;
    }
    
    //metodo que cuenta la cantidad de eventos buscados
    public List contarEventos(String busqueda){
        String SQL_ContarEventos="select count(*) from incidencias where fecha LIKE '%"+busqueda+"%' or usuario LIKE '%"+busqueda+"%' or nombreHost LIKE '%"+busqueda+"%'";
        List<Incidencia>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_ContarEventos);
            res=pstm.executeQuery();
            
            while(res.next()){
                Incidencia equipo = new Incidencia();
                equipo.setContar(res.getString(1));
                lista.add(equipo);
            }
        }
        catch (Exception e) {
            System.out.println("Error al consultar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
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