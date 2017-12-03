package com.example.inin.injob;

import com.example.inin.injob.models.jobs.preinterview.PreInterviewMainResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Andres Canu on 1/12/2017.
 */

public interface FileUploadService {
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

}