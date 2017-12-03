package com.example.inin.injob.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import lombok.Data;

/**
 * Created by Andres Canu on 3/12/2017.
 */

@Data
public class RegisterModel {

    @SerializedName("mail")
    @Expose
    private String mail;

    @SerializedName("pais")
    @Expose
    private Integer pais;

    @SerializedName("pass")
    @Expose
    private String pass;
}
