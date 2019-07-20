package com.example.thanhfoododer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class thucdonAdapter extends RecyclerView.Adapter<thucdonAdapter.ViewHoder> {

    List<ThucDon> thucDons;

    public thucdonAdapter(List<ThucDon> thucDons) {
        this.thucDons = thucDons;
    }

    IOnClickThucDon iOnClickThucDon;

    public void setiOnClickThucDon(IOnClickThucDon iOnClickThucDon) {
        this.iOnClickThucDon = iOnClickThucDon;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.iteamthucdon, parent, false);
        ViewHoder viewHoder = new ViewHoder(view);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        final ThucDon thucDon = thucDons.get(position);

        holder.tvName.setText(thucDon.getName());
        holder.tvPrice.setText((int) thucDon.getPrice());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClickThucDon.onClickName(thucDon.getName());
            }
        });

        holder.tvPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClickThucDon.onclickPrice(thucDon.getPrice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }

}
