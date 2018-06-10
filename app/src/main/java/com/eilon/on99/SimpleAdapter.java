package com.eilon.on99;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eilon on 10/6/2018.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private List<String> data;

    public SimpleAdapter(ArrayList<String> d) {
        data = d;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: "+data.get(position));
        String s = data.get(position);
        holder.bind(s);
    }

    public void setData(List<String> list) {
        data = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
