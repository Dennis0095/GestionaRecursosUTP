package DAOS;

import ConexionBD.ConexionDB;
import DTOS.Equipos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquiposDAO{
    public static PreparedStatement pstm=null; // PreparedStatement = realizar consulta
    public static ResultSet res=null;          // ResultSet=almacena resultado de la consulta a la DB
    public static ConexionDB con = ConexionDB.getInstance(); // establece una instancia de conexion a la BD
    
    /*QUERYS QUE SE VAN A REALIZAR A LA BD*/
    public static final String SQL_INSERT="insert into equipos(nombreHost,tipo,marca,modelo,serie,caf,ubicacion,area,observaciones)values(?,?,?,?,?,?,?,?,?)" ;
        
    public boolean atributos(Equipos atributo){//LOGUEAR USUARIO OPERACION
        return false;
    }
    
    //INTOCABLE
    public Boolean insertar(Equipos t) {
        boolean result=false;
        try{
            pstm=con.getConnection().prepareStatement(SQL_INSERT); //abre conexion para datos
            pstm.setString(1,t.getNombreHost());
            pstm.setString(2,t.getTipo());    //obtiene los datos ingresados en los formularios a la clase, aqui recien se define el tipo de dato
            pstm.setString(3,t.getMarca());
            pstm.setString(4,t.getModelo());
            pstm.setString(5,t.getSerie());
            pstm.setString(6,t.getCaf());
            pstm.setString(7,t.getUbicacion());
            pstm.setString(8,t.getArea());
            pstm.setString(9,t.getObservaciones());
            
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
  
    //INTOCABLE
    public Boolean modificar(Equipos t) {
        boolean result=false;
        String SQL_UPDATE="update equipos set nombreHost=?,tipo=?,marca=?,modelo=?,serie=?,caf=?,ubicacion=?,area=?,observaciones=? where id=?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1,t.getNombreHost());
            pstm.setString(2,t.getTipo());
            pstm.setString(3,t.getMarca());
            pstm.setString(4,t.getModelo());
            pstm.setString(5,t.getSerie());
            pstm.setString(6,t.getCaf());
            pstm.setString(7,t.getUbicacion());
            pstm.setString(8,t.getArea());
            pstm.setString(9,t.getObservaciones());
            pstm.setString(10,t.getId());
            
            if (pstm.executeUpdate() > 0) {
                result=true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return result;
    }

    public Boolean borrar(String id) {
        boolean result=false;
        try{
           pstm=con.getConnection().prepareStatement("delete from equipos where id="+id);
           if (pstm.executeUpdate() > 0) {
                result=true;
            }

        }catch(Exception e){
            System.out.println("Error al borrar");
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return result;
    } 

    //INTOCABLE
    public Equipos selectById(String id) {
        Equipos equipo = new Equipos();
        try{
            pstm=con.getConnection().prepareStatement("select * from equipos where id="+id);
            res=pstm.executeQuery();
            while(res.next()){
                equipo.setId(res.getString(1));
                equipo.setNombreHost(res.getString(2));
                equipo.setTipo(res.getString(3));
                equipo.setMarca(res.getString(4));           
                equipo.setModelo(res.getString(5));
                equipo.setSerie(res.getString(6));
                equipo.setCaf(res.getString(7));
                equipo.setUbicacion(res.getString(8));
                equipo.setArea(res.getString(9));
                equipo.setObservaciones(res.getString(10));
            }
        }
        catch(Exception e){
        }
        return equipo;
    }
    
    //ULTIMOS
    public List Ultimos(){
        String SQL_ULTIMOS="select top 3 * from equipos order by id desc";
        List<Equipos>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_ULTIMOS);
            res=pstm.executeQuery();
            
            while(res.next()){
                Equipos equipo = new Equipos();
                equipo.setId(res.getString(1));
                equipo.setNombreHost(res.getString(2));
                equipo.setTipo(res.getString(3));
                equipo.setMarca(res.getString(4));           
                equipo.setModelo(res.getString(5));
                equipo.setSerie(res.getString(6));
                equipo.setCaf(res.getString(7));
                equipo.setUbicacion(res.getString(8));
                equipo.setArea(res.getString(9));
                equipo.setObservaciones(res.getString(10));
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

//metodo que busca los equipos
    public List Busqueda(String busqueda){
        String SQL_BUSQUEDA="select * from equipos where nombreHost LIKE '%"+busqueda+"%' or tipo LIKE '%"+busqueda+"%' or marca LIKE '%"+busqueda+"%' or modelo LIKE '%"+busqueda+"%'or serie LIKE '%"+busqueda+"%'or caf LIKE '"+busqueda+"%'or ubicacion LIKE '%"+busqueda+"%' or area LIKE '%"+busqueda+"%'";
        List<Equipos>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_BUSQUEDA);
            res=pstm.executeQuery();
            while(res.next()){
                Equipos equipo = new Equipos();
                equipo.setId(res.getString(1));
                equipo.setNombreHost(res.getString(2));
                equipo.setTipo(res.getString(3));
                equipo.setMarca(res.getString(4));           
                equipo.setModelo(res.getString(5));
                equipo.setSerie(res.getString(6));
                equipo.setCaf(res.getString(7));
                equipo.setUbicacion(res.getString(8));
                equipo.setArea(res.getString(9));
                equipo.setObservaciones(res.getString(10));
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

//metodo que cuenta los registros buscados
    public List contarPOR(String busqueda){
        String SQL_BUSQUEDA="select count(*) from equipos where nombreHost LIKE'"+busqueda+"%' or tipo LIKE'"+busqueda+"%' or marca LIKE'"+busqueda+"%' or modelo LIKE'"+busqueda+"%'or serie LIKE'"+busqueda+"%'or caf LIKE '"+busqueda+"%'or ubicacion LIKE'"+busqueda+"%' or area LIKE '"+busqueda+"%'";
        List<Equipos>lista=new ArrayList<>();
        try{
            pstm=con.getConnection().prepareStatement(SQL_BUSQUEDA);
            res=pstm.executeQuery();
            
            while(res.next()){
                Equipos equipo = new Equipos();
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
    
//INTOCABLE
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