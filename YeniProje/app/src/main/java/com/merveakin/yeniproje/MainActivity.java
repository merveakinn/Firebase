package com.merveakin.yeniproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.merveakin.yeniproje.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();

    }
    public void girisyap(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }

    public void kayıtol(View view){

        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }


}