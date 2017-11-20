
package com.example.inin.injob.models.cv1;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CvResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private DataCV1 data;


    private final static long serialVersionUID = -9191474806409885869L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CvResponse() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public CvResponse(Boolean success, String message, DataCV1 data) {
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

    public DataCV1 getData() {
        return data;
    }

    public void setData(DataCV1 data) {
        this.data = data;
    }

}
