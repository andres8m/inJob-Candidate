
package com.example.inin.injob.models.cv2;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("curriculum")
    @Expose
    private Integer curriculum;
    @SerializedName("job")
    @Expose
    private Integer job;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 5204948185687802888L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param job
     * @param curriculum
     */
    public Datum(Integer id, Integer curriculum, Integer job, String name) {
        super();
        this.id = id;
        this.curriculum = curriculum;
        this.job = job;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Integer curriculum) {
        this.curriculum = curriculum;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
