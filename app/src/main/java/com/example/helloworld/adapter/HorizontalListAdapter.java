package com.example.helloworld.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.model.ListItem;

import java.util.List;

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.HorizontalListViewHolder> {

    List<ListItem> mData;

    HorizontalListAdapter(List<ListItem> data){
        this.mData = data;
    }


    @NonNull
    @Override
    public HorizontalListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vertical_list_item, parent, false);
        return new HorizontalListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalListViewHolder holder, int position) {

        holder.imageView.setImageResource(mData.get(position).getImageResource());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HorizontalListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public HorizontalListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

}
