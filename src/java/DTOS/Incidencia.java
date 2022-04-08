package DTOS;

public class Incidencia {
    private String id;
    private String fecha;
    private String usuario;
    private String nombreHost;
    private String descripcion;
    private String contar;

    public Incidencia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreHost() {
        return nombreHost;
    }

    public void setNombreHost(String nombreHost) {
        this.nombreHost = nombreHost;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }   

    public String getContar() {
        return contar;
    }

    public void setContar(String contar) {
        this.contar = contar;
    }
}