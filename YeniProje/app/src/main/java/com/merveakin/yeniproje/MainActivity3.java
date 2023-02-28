package com.merveakin.yeniproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.merveakin.yeniproje.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();

    }

    public void name(View view) {

    }
    public void kayıtol2(View view) {

        String adsoyad = binding.adsoyadtext.getText().toString();
        String email = binding.emailtext.getText().toString();
        String sifre = binding.sifretext.getText().toString();
        String telefon = binding.telefontext.getText().toString();

        if(adsoyad.equals("")|| sifre.equals("")|| email.equals("")|| telefon.equals("")){
            Toast.makeText(this,"Bilgilerinizi Giriniz",Toast.LENGTH_LONG).show();
        }else{
            auth.createUserWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity3.this, AnaEkran.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(MainActivity3.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });



        Intent intent = new Intent(MainActivity3.this, AnaEkran.class);
        startActivity(intent);

    }
} }