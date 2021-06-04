package com.example.uts_10118060_permai.main.daily;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_10118060_permai.R;
import com.example.uts_10118060_permai.main.daily.adapter.UsersAdapter;
import com.example.uts_10118060_permai.main.daily.model.User;
import com.example.uts_10118060_permai.main.dashboard.DashboardActivity;
import com.example.uts_10118060_permai.main.gallery.GalleryActivity;
import com.example.uts_10118060_permai.main.music.MusicActivity;
import com.example.uts_10118060_permai.main.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

//2 June 2021, 10118060, Permai Ramadhan, IF-2
public class DailyActivity extends AppCompatActivity {
    private RecyclerView usersList;
    private UsersAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        usersList = findViewById(R.id.usersList);
        userAdapter = new UsersAdapter();
        usersList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        usersList.setHasFixedSize(true);
        usersList.setAdapter(userAdapter);


        userAdapter.addUser(new User("A", "M.Hilmy Naufal"));
        userAdapter.addUser(new User("B", "M.Ilham Apriyadi"));
        userAdapter.addUser(new User("C", "M.Rakha Firdaus"));
        userAdapter.addUser(new User("D", "Mirraz Ibrahim"));
        userAdapter.addUser(new User("E", "Niko Yama"));
        userAdapter.addUser(new User("F", "Reza Pratama"));
        userAdapter.addUser(new User("G", "Taufiq Rizky"));

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.dailyId);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dailyId:
                        startActivity(new Intent(getApplicationContext(), DailyActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homeId:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.galleryId:
                        startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.musicId:
                        startActivity(new Intent(getApplicationContext(), MusicActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profileId:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }


}