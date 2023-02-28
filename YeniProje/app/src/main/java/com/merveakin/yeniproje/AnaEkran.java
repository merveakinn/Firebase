package com.merveakin.yeniproje;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.merveakin.yeniproje.adapter.EvlerAdapter;
import com.merveakin.yeniproje.databinding.ActivityAnaEkranBinding;
import com.merveakin.yeniproje.model.Evler;


import java.util.ArrayList;
import java.util.Map;

public class AnaEkran extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<Evler> evlerArrayList;

    private ActivityAnaEkranBinding binding;
    EvlerAdapter evlerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnaEkranBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        evlerArrayList = new ArrayList<Evler>();
        auth = FirebaseAuth.getInstance();

        firebaseFirestore =  FirebaseFirestore.getInstance();


        getData();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        evlerAdapter = new EvlerAdapter(evlerArrayList);
        binding.recyclerView.setAdapter(evlerAdapter);


    }

    private void getData(){

        firebaseFirestore.collection("Evler").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null){
                    Toast.makeText(AnaEkran.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                if(value!=null){
                    for(DocumentSnapshot snapshot : value.getDocuments()){
                        Map<String,Object> data = snapshot.getData();


                        //Casting
                        String userEmail = (String) data.get("useremail");
                        String comment = (String) data.get("comment");
                        String adres = (String) data.get("adres");
                        String ucret = (String) data.get("ucret");
                        String downloadUrl = (String) data.get("downloadurl");

                        Evler evler = new Evler(userEmail,comment,downloadUrl,adres,ucret);

                        evlerArrayList.add(evler);


                    }
                    evlerAdapter.notifyDataSetChanged();

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== R.id.menuu){
            Intent intent = new Intent(this, AnaEkran2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }





    public void name(View view) {


    }


}