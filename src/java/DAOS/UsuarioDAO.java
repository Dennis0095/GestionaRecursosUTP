package DAOS;

import ConexionBD.ConexionDB;
import DTOS.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static PreparedStatement pstm=null; // PreparedStatement = realizar consulta
    private static ResultSet res=null;          // ResultSet=almacena resultado de la consulta a la DB
    private static final ConexionDB con = ConexionDB.getInstance(); // establece una instancia de conexion a la BD
    
    /*QUERYS QUE SE VAN A REALIZAR A LA BD*/
    private static final String SQL_UPDATE="update usuarios set clave = ";//definir para modificar
    private static final String SQL_DELETE="";//definir para borrar
    private static final String SQL_LOGIN="select nombres, apellidos, usuario, clave, correo, area, perfil, estado from usuarios where usuario=? and clave=?";
    private static final String SQL_PERFIL="select perfil from usuarios where usuario=? and clave=?"; 
    
    
    public Boolean insertar(Usuario t) {
        boolean result=false;
        String SQL_INSERT="insert into usuarios(nombres,apellidos,usuario,clave,correo,area,perfil)values(?,?,?,?,?,?,?)";
               
        try{
            pstm=con.getConnection().prepareStatement(SQL_INSERT); //abre conexion para datos
            pstm.setString(1,t.getNombres());
            pstm.setString(2,t.getApellidos());    //obtiene los datos ingresados en los formularios a la clase, aqui recien se define el tipo de dato
            pstm.setString(3,t.getUser());
            pstm.setString(4,t.getClave());
            pstm.setString(5,t.getCorreo());
            pstm.setString(6,t.getArea());
            pstm.setString(7,t.getPerfil());
            
            if(pstm.executeUpdate()>0){ //se usa el update cuando se modifica el estado del registro de la DB (crear,modificar o eliminar), se usa query cuando se hace consulta
                result=true;            //result es true cuando se ejecuta la transaccion
            }
        }
        catch (Exception e){
            System.out.println("Error al insertar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return result;
    }
        
    public Boolean borrar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario loguear(Usuario t) { 
        Usuario user=null;
        try{
            pstm=con.getConnection().prepareStatement(SQL_LOGIN);
            pstm.setString(1,t.getUser());
            pstm.setString(2,t.getClave());
            res=pstm.executeQuery();
            //VALIDAR QUE EXISTE UN USUARIO AL MENOS    
            while(res.next()){
                user = new Usuario();
                user.setNombres(res.getString(1));
                user.setApellidos(res.getString(2));
                user.setUser(res.getString(3));
                //no se setea clave porque no se va a llamar ese valor
                user.setCorreo(res.getString(5));
                user.setArea(res.getString(6));
                user.setPerfil(res.getString(7));//jala la columna perfil
            }
        }
        catch (Exception e){
            System.out.println("Error al loguear: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return user;
    }
    
    public List buscarUsuario(String busqueda){
        String SQL_BUSCAUSER = "select * from usuarios where nombres LIKE '%"+busqueda+"%' or apellidos LIKE '%"+busqueda+"%' or usuario LIKE '"+busqueda+"%' or correo LIKE '%"+busqueda+"%' or area LIKE '%"+busqueda+"%' or perfil LIKE '%"+busqueda+"%'";
        List<Usuario>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_BUSCAUSER);
            res=pstm.executeQuery();
            while(res.next()){
                Usuario usuario = new Usuario();
                usuario.setId(res.getString(1));
                usuario.setNombres(res.getString(2));
                usuario.setApellidos(res.getString(3));
                usuario.setUser(res.getString(4));
                usuario.setCorreo(res.getString(6));
                usuario.setArea(res.getString(7));
                usuario.setPerfil(res.getString(8));
                lista.add(usuario);
            }
        }
        catch (Exception e){
            System.out.println("Error al buscar: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public List contarUSER(String busqueda){
        String SQL_BUSQUEDA="select count(*) from usuarios where nombres LIKE'"+busqueda+"%' or apellidos LIKE'"+busqueda+"%' or usuario LIKE'"+busqueda+"%' or correo LIKE'"+busqueda+"%'or area LIKE'"+busqueda+"%'or perfil LIKE '"+busqueda+"%'";
        List<Usuario>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_BUSQUEDA);
            res=pstm.executeQuery();
            
            while(res.next()){
                Usuario usuario = new Usuario();
                usuario.setCuenta(res.getString(1));
                lista.add(usuario);
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