package com.example.uts_10118060_permai.main.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uts_10118060_permai.R;
import com.example.uts_10118060_permai.main.daily.DailyActivity;
import com.example.uts_10118060_permai.main.gallery.GalleryActivity;
import com.example.uts_10118060_permai.main.music.MusicActivity;
import com.example.uts_10118060_permai.main.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

//2 June 2021, 10118060, Permai Ramadhan, IF-2
public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.homeId);

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