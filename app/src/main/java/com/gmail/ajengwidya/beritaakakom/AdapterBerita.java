package com.gmail.ajengwidya.beritaakakom;

/**
 * Created by student on 12/14/2018.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<DataBerita> data= Collections.emptyList();
    DataBerita current;
    int currentPos=0;

    public AdapterBerita(Context context, List<DataBerita> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.konten_berita, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        DataBerita current=data.get(position);
        myHolder.textJudul.setText(current.judulBerita);
        myHolder.textTanggal.setText("tgl: " + current.tglPosting);
        myHolder.textBerita.setText("konten: " + current.isiBerita);

        Glide.with(context).load("http://belajar-unggah.000webhostapp.com/test/images/" + current.gambarBerita)
                .placeholder(R.drawable.ic_android_black)
                .error(R.drawable.ic_android_black)
                .into(myHolder.ivBerita);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textJudul;
        ImageView ivBerita;
        TextView textTanggal;
        TextView textBerita;

        public MyHolder(View itemView) {
            super(itemView);
            textJudul= (TextView) itemView.findViewById(R.id.judul);
            ivBerita= (ImageView) itemView.findViewById(R.id.imageView2);
            textTanggal = (TextView) itemView.findViewById(R.id.tanggal);
            textBerita = (TextView) itemView.findViewById(R.id.isi);
        }
    }
}
