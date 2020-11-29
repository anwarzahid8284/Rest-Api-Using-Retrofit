package com.example.retrofitmysql.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitmysql.Model.Student;
import com.example.retrofitmysql.R;
import com.example.retrofitmysql.Retrofit.ApiClient;
import com.example.retrofitmysql.Retrofit.GetApiClient;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisteredActivity extends AppCompatActivity {
    EditText editTextUName,editTextEmail,editTextPhoneNo,editTextPassword;
    GetApiClient getApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        editTextUName=(EditText)findViewById(R.id.userNameId);
        editTextEmail=(EditText)findViewById(R.id.emailId);
        editTextPhoneNo=(EditText)findViewById(R.id.phoneId);
        editTextPassword=(EditText)findViewById(R.id.passwordId);
        getApiClient=ApiClient.getRetrofit().create(GetApiClient.class);
    }

    public void Submit(View view) {
        String userName=editTextUName.getText().toString().trim();
        String userEmail=editTextEmail.getText().toString().trim();
        String userPhone=editTextPhoneNo.getText().toString().trim();
        String userPassword=editTextPassword.getText().toString().trim();
        // call to web service using  retrofit
        final Call<Student> studentCall=getApiClient.stdRegistered(userName,userEmail,userPhone,userPassword);
        studentCall.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(response.isSuccessful()){
                    Student student=response.body();
                    if (student.getSuccess()) {
                       Toast.makeText(RegisteredActivity.this,student.getMessage(),Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisteredActivity.this,student.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(RegisteredActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}