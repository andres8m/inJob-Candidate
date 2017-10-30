package com.example.inin.injob.models.cv1;



public class Cv1UserData {

//    private static Cv1UserData instance;


    private String nombre;

    private String apellido;

    private String direccion;

    private String zona;

    private String celular;

    private String telefono;

    private String genero;

    private Long nacimiento;

    private String licencia;

    private Boolean visa;

    private String foto;

    private Boolean policiacos;

    private Boolean penales;

    private Boolean documento;

    private Long usuario;

    private String identificacion;

    private Long pais;

    private Long departamento;

    private Long municipio;

    private Integer nacionalidad;

//    public Cv1UserData() {}

    public Cv1UserData() {
    }

//    public static Cv1UserData Instance()
//    {
//        //if no instance is initialized yet then create new instance
//        //else return stored instance
//        if (instance == null)
//        {
//            instance = new Cv1UserData();
//        }
//        return instance;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Long nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Boolean getVisa() {
        return visa;
    }

    public void setVisa(Boolean visa) {
        this.visa = visa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getPoliciacos() {
        return policiacos;
    }

    public void setPoliciacos(Boolean policiacos) {
        this.policiacos = policiacos;
    }

    public Boolean getPenales() {
        return penales;
    }

    public void setPenales(Boolean penales) {
        this.penales = penales;
    }

    public Boolean getDocumento() {
        return documento;
    }

    public void setDocumento(Boolean documento) {
        this.documento = documento;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Long departamento) {
        this.departamento = departamento;
    }

    public Long getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Long municipio) {
        this.municipio = municipio;
    }

    public Integer getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Integer nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
