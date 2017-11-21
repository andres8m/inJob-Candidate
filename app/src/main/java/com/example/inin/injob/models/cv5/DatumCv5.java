
package com.example.inin.injob.models.cv5;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCv5 implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("languajeId")
    @Expose
    private Integer languajeId;

    @SerializedName("materno")
    @Expose
    private Boolean materno;

    @SerializedName("comprensionAuditiva")
    @Expose
    private Integer comprensionAuditiva;

    @SerializedName("comprensionLectora")
    @Expose
    private Integer comprensionLectora;

    @SerializedName("interaccionOral")
    @Expose
    private Integer interaccionOral;

    @SerializedName("expresionOral")
    @Expose
    private Integer expresionOral;

    @SerializedName("expresionEscrita")
    @Expose
    private Integer expresionEscrita;

    @SerializedName("languaje")
    @Expose
    private Languaje languaje;

    private final static long serialVersionUID = 459172166519189462L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumCv5() {
    }

    /**
     * 
     * @param expresionEscrita
     * @param id
     * @param comprensionAuditiva
     * @param expresionOral
     * @param materno
     * @param languaje
     * @param comprensionLectora
     * @param languajeId
     * @param interaccionOral
     */
    public DatumCv5(Integer id, Integer languajeId, Boolean materno, Integer comprensionAuditiva, Integer comprensionLectora, Integer interaccionOral, Integer expresionOral, Integer expresionEscrita, Languaje languaje) {
        super();
        this.id = id;
        this.languajeId = languajeId;
        this.materno = materno;
        this.comprensionAuditiva = comprensionAuditiva;
        this.comprensionLectora = comprensionLectora;
        this.interaccionOral = interaccionOral;
        this.expresionOral = expresionOral;
        this.expresionEscrita = expresionEscrita;
        this.languaje = languaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLanguajeId() {
        return languajeId;
    }

    public void setLanguajeId(Integer languajeId) {
        this.languajeId = languajeId;
    }

    public Boolean getMaterno() {
        return materno;
    }

    public void setMaterno(Boolean materno) {
        this.materno = materno;
    }

    public Integer getComprensionAuditiva() {
        return comprensionAuditiva;
    }

    public void setComprensionAuditiva(Integer comprensionAuditiva) {
        this.comprensionAuditiva = comprensionAuditiva;
    }

    public Integer getComprensionLectora() {
        return comprensionLectora;
    }

    public void setComprensionLectora(Integer comprensionLectora) {
        this.comprensionLectora = comprensionLectora;
    }

    public Integer getInteraccionOral() {
        return interaccionOral;
    }

    public void setInteraccionOral(Integer interaccionOral) {
        this.interaccionOral = interaccionOral;
    }

    public Integer getExpresionOral() {
        return expresionOral;
    }

    public void setExpresionOral(Integer expresionOral) {
        this.expresionOral = expresionOral;
    }

    public Integer getExpresionEscrita() {
        return expresionEscrita;
    }

    public void setExpresionEscrita(Integer expresionEscrita) {
        this.expresionEscrita = expresionEscrita;
    }

    public Languaje getLanguaje() {
        return languaje;
    }

    public void setLanguaje(Languaje languaje) {
        this.languaje = languaje;
    }

}
