package com.kuycoding.rumahadat.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.rumahadat.DetailrumahActivity;
import com.kuycoding.rumahadat.R;
import com.kuycoding.rumahadat.model.RumahModel;

import java.util.ArrayList;

public class ListRumahAdapter extends RecyclerView.Adapter<ListRumahAdapter.ListViewHolder> {
    Context c;

    private ArrayList<RumahModel> listRumah;

    public ListRumahAdapter(ArrayList<RumahModel> list,Context c) {
        this.listRumah = list;
        this.c = c;
    }

    private ArrayList<RumahModel> getListRumah(){
        return listRumah;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_rumah, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        RumahModel rumah = listRumah.get(position);
        final String gambarRumahAdat = rumah.getPhoto();
        final String namaRumahAdat = rumah.getName();
        final String fromRumahAdat = rumah.getFrom();
        final String desRumahAdat = rumah.getKeterangan();

        Glide.with(holder.itemView.getContext())
                .load(rumah.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(rumah.getName());
        holder.tvKeterangan.setText(rumah.getKeterangan());
        holder.tvFrom.setText(rumah.getFrom());

        holder.imgPhoto.setImageURI(Uri.parse(gambarRumahAdat));
        holder.tvName.setText(namaRumahAdat);
        holder.tvFrom.setText(fromRumahAdat);
        holder.tvKeterangan.setText(desRumahAdat);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listRumah.get(holder.getAdapterPosition()));
                OpenDetail(gambarRumahAdat,namaRumahAdat,fromRumahAdat,desRumahAdat);
            }
        });
    }

    private void OpenDetail(String gambarRumahAdat, String namaRumahAdat, String fromRumahAdat, String desRumahAdat) {
        Intent move = new Intent(c, DetailrumahActivity.class);
        move.putExtra("POTO",gambarRumahAdat);
        move.putExtra("NAMA",namaRumahAdat);
        move.putExtra("ASAL",fromRumahAdat);
        move.putExtra("KET",desRumahAdat);
        c.startActivity(move);
    }


    @Override
    public int getItemCount() {
        return listRumah.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom, tvKeterangan;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvKeterangan = itemView.findViewById(R.id.tv_item_des);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(RumahModel data);
    }

}
