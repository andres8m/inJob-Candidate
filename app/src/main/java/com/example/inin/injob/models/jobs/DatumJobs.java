
package com.example.inin.injob.models.jobs;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumJobs implements Serializable
{

    @SerializedName("search")
    @Expose
    private String search;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("submit_date")
    @Expose
    private Integer submitDate;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("idPreinterview")
    @Expose
    private Integer idPreinterview;


    private final static long serialVersionUID = -3291829325601849463L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumJobs() {
    }

    /**
     * 
     * @param title
     * @param search
     * @param description
     * @param submitDate
     * @param company
     * @param idPreinterview
     */
    public DatumJobs(String search, String title, String company, Integer submitDate, String description, Integer idPreinterview) {
        super();
        this.search = search;
        this.title = title;
        this.company = company;
        this.submitDate = submitDate;
        this.description = description;
        this.idPreinterview = idPreinterview;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Integer submitDate) {
        this.submitDate = submitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdPreinterview() {
        return idPreinterview;
    }

    public void setIdPreinterview(Integer idPreinterview) {
        this.idPreinterview = idPreinterview;
    }

}
