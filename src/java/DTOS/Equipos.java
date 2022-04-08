package DTOS;

public class Equipos {
    private String id;
    private String nombreHost;
    private String tipo;
    private String marca;
    private String modelo;
    private String serie;
    private String caf;
    private String ubicacion;
    private String area;
    private String observaciones;
    private String contar;
       
    public Equipos(){
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreHost() {
        return nombreHost;
    }

    public void setNombreHost(String nombreHost) {
        this.nombreHost = nombreHost;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    
    public String getCaf() {
        return caf;
    }

    public void setCaf(String caf) {
        this.caf = caf;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getContar() {
        return contar;
    }

    public void setContar(String contar) {
        this.contar = contar;
    }
}