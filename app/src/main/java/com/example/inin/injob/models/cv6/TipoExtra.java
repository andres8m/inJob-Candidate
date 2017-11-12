
package com.example.inin.injob.models.cv6;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoExtra implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    private final static long serialVersionUID = -2381352809938558754L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TipoExtra() {
    }

    /**
     * 
     * @param id
     * @param descripcion
     */
    public TipoExtra(Long id, String descripcion) {
        super();
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
