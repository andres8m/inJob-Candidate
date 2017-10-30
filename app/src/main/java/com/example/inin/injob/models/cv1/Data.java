
package com.example.inin.injob.models.cv1;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("zona")
    @Expose
    private String zona;
    @SerializedName("celular")
    @Expose
    private String celular;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("genero")
    @Expose
    private String genero;
    @SerializedName("nacimiento")
    @Expose
    private Long nacimiento;
    @SerializedName("licencia")
    @Expose
    private String licencia;
    @SerializedName("visa")
    @Expose
    private Boolean visa;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("policiacos")
    @Expose
    private Boolean policiacos;
    @SerializedName("penales")
    @Expose
    private Boolean penales;
    @SerializedName("documento")
    @Expose
    private Boolean documento;
    @SerializedName("usuario")
    @Expose
    private Long usuario;
    @SerializedName("identificacion")
    @Expose
    private String identificacion;
    @SerializedName("pais")
    @Expose
    private Long pais;
    @SerializedName("departamento")
    @Expose
    private Long departamento;
    @SerializedName("municipio")
    @Expose
    private Long municipio;
    @SerializedName("nacionalidad")
    @Expose

    private Integer nacionalidad;

    private final static long serialVersionUID = -797541353171941056L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param apellido
     * @param direccion
     * @param pais
     * @param licencia
     * @param usuario
     * @param nacimiento
     * @param telefono
     * @param documento
     * @param nombre
     * @param identificacion
     * @param genero
     * @param municipio
     * @param departamento
     * @param penales
     * @param zona
     * @param foto
     * @param visa
     * @param policiacos
     * @param nacionalidad
     * @param celular
     */
    public Data(String nombre, String apellido, String direccion, String zona, String celular, String telefono, String genero, Long nacimiento, String licencia, Boolean visa, String foto, Boolean policiacos, Boolean penales, Boolean documento, Long usuario, String identificacion, Long pais, Long departamento, Long municipio, Integer nacionalidad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.zona = zona;
        this.celular = celular;
        this.telefono = telefono;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.licencia = licencia;
        this.visa = visa;
        this.foto = foto;
        this.policiacos = policiacos;
        this.penales = penales;
        this.documento = documento;
        this.usuario = usuario;
        this.identificacion = identificacion;
        this.pais = pais;
        this.departamento = departamento;
        this.municipio = municipio;
        this.nacionalidad = nacionalidad;
    }

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
