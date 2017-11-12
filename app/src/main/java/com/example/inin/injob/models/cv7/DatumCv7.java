
package com.example.inin.injob.models.cv7;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCv7 implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("tipoReferencia")
    @Expose
    private Long tipoReferencia;

    @SerializedName("curriculum")
    @Expose
    private Long curriculum;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellido")
    @Expose
    private String apellido;

    @SerializedName("telefono")
    @Expose
    private String telefono;

    @SerializedName("correo")
    @Expose
    private String correo;

    private final static long serialVersionUID = 8122140334855184451L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumCv7() {
    }

    /**
     * 
     * @param apellido
     * @param nombre
     * @param id
     * @param telefono
     * @param curriculum
     * @param tipoReferencia
     * @param correo
     */
    public DatumCv7(Long id, Long tipoReferencia, Long curriculum, String nombre, String apellido, String telefono, String correo) {
        super();
        this.id = id;
        this.tipoReferencia = tipoReferencia;
        this.curriculum = curriculum;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(Long tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public Long getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Long curriculum) {
        this.curriculum = curriculum;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
