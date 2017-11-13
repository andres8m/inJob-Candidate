
package com.example.inin.injob.models.cv1.town;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TownResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DatumTown> data = null;
    private final static long serialVersionUID = -262784731528744714L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TownResponse() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public TownResponse(Boolean success, String message, List<DatumTown> data) {
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

    public List<DatumTown> getData() {
        return data;
    }

    public void setData(List<DatumTown> data) {
        this.data = data;
    }

}
