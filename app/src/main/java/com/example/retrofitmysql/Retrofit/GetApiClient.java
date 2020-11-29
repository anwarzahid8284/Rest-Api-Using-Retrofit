package com.example.retrofitmysql.Retrofit;

import com.example.retrofitmysql.Model.Student;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetApiClient {

    @FormUrlEncoded
    @POST("loginUser.php")//add this line call the below method
    Call<Student> stdLogin(@Field("userEmail") String emil, @Field("userPassword") String password);
    @FormUrlEncoded
    @POST("registeredUser.php")//add this line call the below method
    Call<Student> stdRegistered(@Field("userName") String userName, @Field("userEmail") String userEmail
    ,@Field("userPhone") String userPhone,@Field("userPassword") String userPassword);
}
