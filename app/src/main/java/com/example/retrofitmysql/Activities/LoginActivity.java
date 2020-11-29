package com.example.retrofitmysql.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitmysql.Model.Student;
import com.example.retrofitmysql.R;
import com.example.retrofitmysql.Retrofit.ApiClient;
import com.example.retrofitmysql.Retrofit.GetApiClient;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    GetApiClient getApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.userNameId);
        editTextPassword = (EditText) findViewById(R.id.passwordId);
        getApiClient = ApiClient.getRetrofit().create(GetApiClient.class);

    }

    // Login user
    public void studentLogin(View view) {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        Call<Student> call = getApiClient.stdLogin(email, password);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {
                    Student student = response.body();
                    if (student.getSuccess()) {
                        Toast.makeText(LoginActivity.this,student.getMessage(),Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this,student.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void studentRegistered(View view) {
        // intent to registered activity
        Intent intentRActivity=new Intent(this,RegisteredActivity.class);
        startActivity(intentRActivity);
        finish();

    }
}