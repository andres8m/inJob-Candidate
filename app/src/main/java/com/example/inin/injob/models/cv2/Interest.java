package com.example.inin.injob.models.cv2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by Andres Canu on 1/12/2017.
 */

@Data
public class Interest {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("area")
    @Expose
    private Integer area;

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("level")
    @Expose
    private Integer level;

    @SerializedName("name")
    @Expose
    private String name;

}
