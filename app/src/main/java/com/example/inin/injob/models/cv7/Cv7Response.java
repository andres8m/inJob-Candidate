
package com.example.inin.injob.models.cv7;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv7Response implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<DatumCv7> data;

    private final static long serialVersionUID = 7595082446854779470L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cv7Response() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public Cv7Response(Boolean success, String message, List<DatumCv7> data) {
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

    public List<DatumCv7> getData() {
        return data;
    }

    public void setData(List<DatumCv7> data) {
        this.data = data;
    }

}
