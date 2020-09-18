package com.example.helloworld.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.helloworld.R;
import com.example.helloworld.model.DataItem;
import com.example.helloworld.model.HorizontalListParent;
import com.example.helloworld.model.ItemViewPagerParent;
import com.example.helloworld.model.ListHeader;
import com.example.helloworld.model.ListItem;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    List<DataItem> data;

    public MyListAdapter(List<DataItem> dataItemList) {

        data = dataItemList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(viewType, parent, false);
        MyViewHolder holder = null;

        switch (viewType) {
            case R.layout.vertical_list_item:
                holder = new VerticalListViewHolder(view);
                break;
            case R.layout.horizontal_list_container:
                holder = new HorizontalListViewHolder(view);
                break;
            case R.layout.list_header:
                holder = new HeaderViewHolder(view);
                break;
            case R.layout.list_viewpager_container:
                holder = new ViewpagerViewHolder(view);
                break;
        }
                return holder;


        }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(data.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof ListItem) {
            return R.layout.vertical_list_item;
        } else if (data.get(position) instanceof HorizontalListParent) {
            return R.layout.horizontal_list_container;
        } else if (data.get(position) instanceof ListHeader) {
            return R.layout.list_header;
        } else if (data.get(position) instanceof ItemViewPagerParent) {
            return R.layout.list_viewpager_container;
        } else
            return R.layout.vertical_list_item;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static abstract class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        abstract void bind(DataItem item);
    }

    public class VerticalListViewHolder extends MyViewHolder {

        ImageView imageView;
        TextView textView;

        public VerticalListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.image_caption);
        }

        @Override
        void bind(DataItem item) {
            ListItem verticalListItem = (ListItem) item;
            imageView.setImageResource(verticalListItem.getImageResource());
            textView.setText(verticalListItem.getCaption());
        }
    }

    public class HorizontalListViewHolder extends MyViewHolder {

        RecyclerView horizontalList;

        public HorizontalListViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalList = itemView.findViewById(R.id.horizontal_list);

        }

        @Override
        void bind(DataItem item) {

            HorizontalListParent horizontalListParent = (HorizontalListParent) item;

            horizontalList.setAdapter(new HorizontalListAdapter(horizontalListParent.getData()));
            horizontalList.setLayoutManager(new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false));

        }
    }

    public class ViewpagerViewHolder extends MyViewHolder {


        ViewPager2 listViewPager;

        public ViewpagerViewHolder(@NonNull View itemView) {
            super(itemView);
            listViewPager = itemView.findViewById(R.id.list_viewpager);
        }

        @Override
        void bind(DataItem item) {
            ItemViewPagerParent itemViewPagerParent = (ItemViewPagerParent) item;
            listViewPager.setAdapter(new ListViewPagerAdapter(itemViewPagerParent.getData()));
        }
    }

    public class HeaderViewHolder extends MyViewHolder {

        TextView header;


        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.list_header);
        }

        @Override
        void bind(DataItem item) {
            ListHeader listHeader = (ListHeader) item;
            header.setText(listHeader.getHeaderText());
        }
    }


}
