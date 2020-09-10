package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    int x;
    BottomNavigationView bottomNavigationView;
    FragmentManager fm;
    FragmentTransaction ft;
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
   //     ft = fm.beginTransaction();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentContainer = findViewById(R.id.fragment_container);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_songs: {
                        FragmentOne fragmentOne = FragmentOne.newInstance();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, fragmentOne).commit();
                        break;
                    }
                    case R.id.navigation_albums: {

                        FragmentTwo fragmentTwo = FragmentTwo.newInstance();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, fragmentTwo).commit();
                        break;

                    }
                    case R.id.navigation_artists: {
                        FragmentThree fragmentThree = FragmentThree.newInstance();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, fragmentThree).commit();
                        break;
                    }
                    default:
                        FragmentOne fragmentOne = FragmentOne.newInstance();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, fragmentOne).commit();
                        break;
                }


                return false;
            }
        });


    }
}