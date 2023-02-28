package com.merveakin.yeniproje.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merveakin.yeniproje.databinding.RecyclerRowBinding;
import com.merveakin.yeniproje.model.Evler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EvlerAdapter extends RecyclerView.Adapter<EvlerAdapter.EvlerHolder> {

    private ArrayList<Evler> evlerArrayList;
    public EvlerAdapter(ArrayList<Evler> evlerArrayList){
        this.evlerArrayList = evlerArrayList;
    }

    @NonNull
    @Override
    public EvlerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new EvlerHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EvlerHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewUserEmailText.setText(evlerArrayList.get(position).email);
        holder.recyclerRowBinding.recyclerViewAdresText.setText(evlerArrayList.get(position).adres);
        holder.recyclerRowBinding.recyclerViewYorumView.setText(evlerArrayList.get(position).comment);
        holder.recyclerRowBinding.recyclerViewUcretText.setText(evlerArrayList.get(position).ucret);

        Picasso.get().load(evlerArrayList.get(position).downloadUrl).into(holder.recyclerRowBinding.recyclerViewImageView);


    }

    @Override
    public int getItemCount() {
        return evlerArrayList.size();
    }

    class EvlerHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;
        public EvlerHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding= recyclerRowBinding;
        }
    }
}
