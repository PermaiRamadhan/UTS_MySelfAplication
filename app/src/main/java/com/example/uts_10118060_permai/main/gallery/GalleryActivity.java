package com.example.uts_10118060_permai.main.gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uts_10118060_permai.R;
import com.example.uts_10118060_permai.main.daily.DailyActivity;
import com.example.uts_10118060_permai.main.dashboard.DashboardActivity;
import com.example.uts_10118060_permai.main.music.MusicActivity;
import com.example.uts_10118060_permai.main.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

//3 June 2021, 10118060, Permai Ramadhan, IF-2
public class GalleryActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {" "," "," "," "," ", " "};
    int[] images = {R.drawable.permai1,R.drawable.permai2,R.drawable.permai3,R.drawable.permai5,
                    R.drawable.permai2,R.drawable.permai3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(names,images,this);

        gridView.setAdapter(customAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = names[i];
                int selectedImage = images[i];

                startActivity(new Intent(GalleryActivity.this,ClickedItemActivity.class)
                        .putExtra("name",selectedName).putExtra("image",selectedImage));
            }
        });

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.galleryId);

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

    public class CustomAdapter extends BaseAdapter {
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items, viewGroup, false);

            }

            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);


            tvName.setText(imageNames[i]);
            imageView.setImageResource(imagesPhoto[i]);



            return view;
        }
    }
}