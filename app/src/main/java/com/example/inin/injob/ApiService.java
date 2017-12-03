package com.example.inin.injob;

import com.example.inin.injob.models.RegisterModel;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewMainResponse;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewRequest;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Andres Canu on 1/12/2017.
 */

public interface ApiService {
    @Multipart
    @POST("document")
    Call<ResponseBody> uploadDPI(
            @Part MultipartBody.Part file,
            @Header("Authorization") String token
    );

    @Multipart
    @POST("records/police")
    Call<ResponseBody> uploadPoliceRecords(
            @Part MultipartBody.Part file,
            @Header("Authorization") String token
    );

    @Multipart
    @POST("records/criminal")
    Call<ResponseBody> uploadCriminalRecords(
            @Part MultipartBody.Part file,
            @Header("Authorization") String token
    );

    @GET("rrhh/preinterview/response/byId")
    Call<PreInterviewMainResponse> getSpecificPreInterview(@Query("preId") Long preId, @Header("Authorization") String token);

    @POST("rrhh/preinterview/response")
    Call<ResponseBody> postPreInterview(@Body List<PreInterviewRequest> request, @Header("Authorization") String token);

    @POST("user/register")
    Call<ResponseBody> registerUser(@Body RegisterModel request);

}