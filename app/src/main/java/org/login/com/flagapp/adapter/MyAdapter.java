package org.login.com.flagapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.login.com.flagapp.R;
import org.login.com.flagapp.model.Country;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Country> countries;
    OnItemClick onItemClick;

    public MyAdapter(List<Country> countries, OnItemClick onItemClick) {
        this.countries = countries;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Country country = countries.get(position);

        holder.mTvName.setText(country.getName());

        holder.mTvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView mTvName;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTvName = itemView.findViewById(R.id.tv_name);
        }
    }


    public interface OnItemClick {
        void onItemClick(Country country);
    }
}
