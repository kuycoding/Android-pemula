package com.kuycoding.rumahadat.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.rumahadat.DetailrumahActivity;
import com.kuycoding.rumahadat.R;
import com.kuycoding.rumahadat.model.RumahModel;

import java.util.ArrayList;

public class CardViewRumahAdapter extends RecyclerView.Adapter<CardViewRumahAdapter.CardViewViewHolder> {

    private Context context;

    private ArrayList<RumahModel> listRumah;
    public CardViewRumahAdapter(ArrayList<RumahModel> list, Context context) {
        this.listRumah = list;
        this.context = context;
    }
    private ArrayList<RumahModel> getListRumah(){
        return listRumah;
    }


    private CardViewRumahAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(CardViewRumahAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardViewRumahAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_rumah, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewRumahAdapter.CardViewViewHolder holder, int position) {
        RumahModel rumah = listRumah.get(position);

        final String gambarRumahAdat = rumah.getPhoto();
        final String namaRumahAdat = rumah.getName();
        final String fromRumahAdat = rumah.getFrom();
        final String desRumahAdat = rumah.getKeterangan();

        Glide.with(holder.itemView.getContext())
                .load(rumah.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(rumah.getName());
        holder.tvKeterangan.setText(rumah.getKeterangan());
        holder.tvFrom.setText(rumah.getFrom());

        holder.imgPhoto.setImageURI(Uri.parse(gambarRumahAdat));
        holder.tvName.setText(namaRumahAdat);
        holder.tvFrom.setText(fromRumahAdat);
        holder.tvKeterangan.setText(desRumahAdat);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDetail(gambarRumahAdat,namaRumahAdat,fromRumahAdat,desRumahAdat);
            }

            private void OpenDetail(String gambarRumahAdat, String namaRumahAdat, String fromRumahAdat, String desRumahAdat) {
                Intent move = new Intent(context, DetailrumahActivity.class);
                move.putExtra("POTO",gambarRumahAdat);
                move.putExtra("NAMA",namaRumahAdat);
                move.putExtra("ASAL",fromRumahAdat);
                move.putExtra("KET",desRumahAdat);
                context.startActivity(move);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listRumah.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 onItemClickCallback.onItemClicked(listRumah.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRumah.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom, tvKeterangan;
        Button btnDetail, btnShare;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvKeterangan = itemView.findViewById(R.id.tv_item_des);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(RumahModel data);
    }
}
