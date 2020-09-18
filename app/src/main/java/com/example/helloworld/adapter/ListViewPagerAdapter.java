package com.example.helloworld.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.helloworld.R;
import com.example.helloworld.model.ListItem;

import java.util.List;

public class ListViewPagerAdapter extends RecyclerView.Adapter<ListViewPagerAdapter.ListPagerViewHolder> {


    List<ListItem> data;

    ListViewPagerAdapter(List<ListItem> mData) {
        this.data = mData;
    }


    @NonNull
    @Override
    public ListPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_viewpager_item, parent, false);

        return new ListPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPagerViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ListPagerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ListPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_viewpager_item_view);
        }
    }

}
