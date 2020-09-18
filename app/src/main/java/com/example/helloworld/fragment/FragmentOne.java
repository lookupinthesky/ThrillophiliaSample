package com.example.helloworld.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.adapter.MyListAdapter;
import com.example.helloworld.model.DataItem;
import com.example.helloworld.model.HorizontalListParent;
import com.example.helloworld.model.ItemViewPagerParent;
import com.example.helloworld.model.ListHeader;
import com.example.helloworld.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        //    args.putInt(ARG_PAGE, page);
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    int[] drawableResources = new int[]{R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        return view;
    }

    RecyclerView recyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        createMasterArrayList();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyListAdapter(masterList));
    }

    private List<DataItem> masterList = new ArrayList<>();
    private List<ListItem> horizontalList1 = new ArrayList<>();
    private List<ListItem> viewPagerList = new ArrayList<>();

    private void createMasterArrayList() {

        masterList.add(new ListHeader("Section A"));

        masterList.add(new ListItem("Image1", drawableResources[0]));
        masterList.add(new ListItem("Image2", drawableResources[1]));
        masterList.add(new ListItem("Image3", drawableResources[2]));
        masterList.add(new ListItem("Image4", drawableResources[3]));
        masterList.add(new ListItem("Image5", drawableResources[4]));

        masterList.add(new ListHeader("Horizontal Recycler View"));

        horizontalList1.add(new ListItem("Image11", drawableResources[0]));
        horizontalList1.add(new ListItem("Image22", drawableResources[1]));
        horizontalList1.add(new ListItem("Image33", drawableResources[2]));
        horizontalList1.add(new ListItem("Image44", drawableResources[3]));
        horizontalList1.add(new ListItem("Image55", drawableResources[4]));
        masterList.add(new HorizontalListParent(horizontalList1));

        masterList.add(new ListHeader("ViewPager inside Recycler View"));

        viewPagerList = horizontalList1;
        masterList.add(new ItemViewPagerParent(viewPagerList));

        masterList.add(new ListHeader("Section B"));

        masterList.add(new ListItem("Image2", drawableResources[1]));
        masterList.add(new ListItem("Image4", drawableResources[3]));
        masterList.add(new ListItem("Image1", drawableResources[0]));
        masterList.add(new ListItem("Image3", drawableResources[2]));
        masterList.add(new ListItem("Image5", drawableResources[4]));

    }
}
