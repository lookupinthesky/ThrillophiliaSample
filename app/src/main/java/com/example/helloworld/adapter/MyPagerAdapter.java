package com.example.helloworld.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.helloworld.fragment.PageFragment;

//use statepageradapter for fragments stateadapter for other one


public class MyPagerAdapter extends FragmentStateAdapter {


    /*public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }*/


    public MyPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
