
package com.example.inin.injob.models.cv2.catalog;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Datum implements Serializable
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("curriculum")
    @Expose
    public Integer curriculum;
    @SerializedName("job")
    @Expose
    public Integer job;
    @SerializedName("name")
    @Expose
    public String name;
    private final static long serialVersionUID = -7059087739833805036L;

}
