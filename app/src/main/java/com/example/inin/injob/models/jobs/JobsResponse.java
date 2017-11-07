
package com.example.inin.injob.models.jobs;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobsResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<DatumJobs> data;


    private final static long serialVersionUID = -8600717958423256021L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public JobsResponse() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public JobsResponse(Boolean success, String message, List<DatumJobs> data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatumJobs> getData() {
        return data;
    }

    public void setData(List<DatumJobs> data) {
        this.data = data;
    }

}
