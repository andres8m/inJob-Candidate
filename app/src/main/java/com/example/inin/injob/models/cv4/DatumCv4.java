
package com.example.inin.injob.models.cv4;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCv4 implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("tittle")
    @Expose
    private String tittle;
    @SerializedName("start")
    @Expose
    private Long start;
    @SerializedName("end")
    @Expose
    private Long end;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("institution")
    @Expose
    private String institution;
    @SerializedName("certificate")
    @Expose
    private Object certificate;
    @SerializedName("degree")
    @Expose
    private Long degree;
    private final static long serialVersionUID = -7749440188189207769L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumCv4() {
    }

    /**
     * 
     * @param id
     * @param certificate
     * @param degree
     * @param status
     * @param start
     * @param tittle
     * @param end
     * @param institution
     */
    public DatumCv4(Long id, String tittle, Long start, Long end, Long status, String institution, Object certificate, Long degree) {
        super();
        this.id = id;
        this.tittle = tittle;
        this.start = start;
        this.end = end;
        this.status = status;
        this.institution = institution;
        this.certificate = certificate;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Object getCertificate() {
        return certificate;
    }

    public void setCertificate(Object certificate) {
        this.certificate = certificate;
    }

    public Long getDegree() {
        return degree;
    }

    public void setDegree(Long degree) {
        this.degree = degree;
    }

}
