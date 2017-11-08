
package com.example.inin.injob.models.cv3;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCv3 implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("start")
    @Expose
    private Long start;

    @SerializedName("end")
    @Expose
    private Long end;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("companyAddress")
    @Expose
    private String companyAddress;
    @SerializedName("companyEmail")
    @Expose
    private Object companyEmail;
    @SerializedName("companyPhone")
    @Expose
    private String companyPhone;
    @SerializedName("companyWebsite")
    @Expose
    private Object companyWebsite;
    private final static long serialVersionUID = -448757188282912040L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumCv3() {
    }

    /**
     * 
     * @param id
     * @param companyWebsite
     * @param companyAddress
     * @param companyEmail
     * @param start
     * @param companyPhone
     * @param description
     * @param company
     * @param job
     * @param end
     */
    public DatumCv3(Integer id, String job, String company, Long start, Long end, String description, String companyAddress, Object companyEmail, String companyPhone, Object companyWebsite) {
        super();
        this.id = id;
        this.job = job;
        this.company = company;
        this.start = start;
        this.end = end;
        this.description = description;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyWebsite = companyWebsite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Object getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(Object companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Object getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(Object companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

}
