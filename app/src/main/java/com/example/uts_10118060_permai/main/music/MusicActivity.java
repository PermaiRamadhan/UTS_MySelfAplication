package com.example.uts_10118060_permai.main.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.uts_10118060_permai.R;
import com.example.uts_10118060_permai.main.daily.DailyActivity;
import com.example.uts_10118060_permai.main.dashboard.DashboardActivity;
import com.example.uts_10118060_permai.main.gallery.GalleryActivity;
import com.example.uts_10118060_permai.main.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//3 June 2021, 10118060, Permai Ramadhan, IF-2
public class MusicActivity extends Activity {

    // Array of strings...
    ListView simpleList;
    String[] musicList = {"Cinta ini Membunuhku - D'MASIV","First Love - Nikka Costa","Pretender - Official DanDism"
                            ,"Silhouette - KANA BOON","Yesterday - Official DanDism","Ubuntu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        VideoView videoView = findViewById(R.id.video_view);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.iklan;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, musicList);
        simpleList.setAdapter(arrayAdapter);


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.musicId);

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