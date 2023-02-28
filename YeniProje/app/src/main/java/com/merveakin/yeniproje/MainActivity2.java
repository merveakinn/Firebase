package com.merveakin.yeniproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.merveakin.yeniproje.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();


        }


    public void name(View view) {

    }
    public void girisyap2(View view) {

        String kullaniciadi = binding.kullaniciadiText.getText().toString();
        String sifre = binding.sifreText.getText().toString();


        if(kullaniciadi.equals("")|| sifre.equals("")){
            Toast.makeText(this,"Bilgilerinizi Giriniz",Toast.LENGTH_LONG).show();
        }else{
            auth.signInWithEmailAndPassword(kullaniciadi,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity2.this, AnaEkran.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(MainActivity2.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });








} } }