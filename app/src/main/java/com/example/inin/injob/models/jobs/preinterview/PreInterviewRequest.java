package com.example.inin.injob.models.jobs.preinterview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by Andres Canu on 3/12/2017.
 */

@Data
public class PreInterviewRequest {

    @SerializedName("answer")
    @Expose
    private String text;

    @SerializedName("question")
    @Expose
    private Long question;

}
