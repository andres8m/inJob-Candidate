
package com.example.inin.injob.models.cv6;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCv6 implements Serializable
{

    @SerializedName("tipoExtraId")
    @Expose
    private Long tipoExtraId;

    @SerializedName("curriculumId")
    @Expose
    private Long curriculumId;

    @SerializedName("valor")
    @Expose
    private String valor;

    @SerializedName("tipoExtra")
    @Expose
    private TipoExtra tipoExtra;

    private final static long serialVersionUID = -3689324081376198419L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumCv6() {
    }

    /**
     * 
     * @param valor
     * @param curriculumId
     * @param tipoExtra
     * @param tipoExtraId
     */
    public DatumCv6(Long tipoExtraId, Long curriculumId, String valor, TipoExtra tipoExtra) {
        super();
        this.tipoExtraId = tipoExtraId;
        this.curriculumId = curriculumId;
        this.valor = valor;
        this.tipoExtra = tipoExtra;
    }

    public Long getTipoExtraId() {
        return tipoExtraId;
    }

    public void setTipoExtraId(Long tipoExtraId) {
        this.tipoExtraId = tipoExtraId;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoExtra getTipoExtra() {
        return tipoExtra;
    }

    public void setTipoExtra(TipoExtra tipoExtra) {
        this.tipoExtra = tipoExtra;
    }

}
