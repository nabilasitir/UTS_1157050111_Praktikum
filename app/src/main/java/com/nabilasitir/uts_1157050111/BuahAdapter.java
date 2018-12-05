package com.nabilasitir.uts_1157050111;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.BuahViewHolder>{
    private List<Buah> buah;
    private Context context;

    public BuahAdapter(List<Buah> buah, Context context) {
        this.buah = buah;
        this.context = context;
    }

    @NonNull
    @Override
    public BuahViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_buah, viewGroup, false);
        return new BuahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuahViewHolder buahViewHolder, int i) {
        final Buah d = buah.get(i);
        buahViewHolder.nama_buah.setText(d.getName());
        buahViewHolder.harga.setText(d.getPrice());
        Picasso.get().load(ApiClient.IMAGE_URL+d.getImage()).error(R.mipmap.ic_launcher)
                .into(buahViewHolder.imageView);

        //event click menampilkan detail cardview
        buahViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(context, DetailList.class);
                //tambaahan
                kirim.putExtra("id",d.getId());
                kirim.putExtra("nam",d.getName());
                kirim.putExtra("hrg",d.getPrice());
                kirim.putExtra("gam",d.getImage());
                kirim.putExtra("det",d.getDetail());
                context.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buah.size();
    }

    class BuahViewHolder extends RecyclerView.ViewHolder {
        TextView nama_buah, harga;
        ImageView imageView;
        public BuahViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_buah = itemView.findViewById(R.id.nama_buah);
            harga = itemView.findViewById(R.id.harga);
            imageView = itemView.findViewById(R.id.gambar);
        }
    }
}
