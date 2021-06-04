package com.example.uts_10118060_permai.main.daily.row;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.uts_10118060_permai.R;

//2 June 2021, 10118060, Permai Ramadhan, IF-2
public class UserRow extends RecyclerView.ViewHolder {

    private TextView usernameTV;

    public UserRow(View itemView) {
        super(itemView);
        usernameTV = itemView.findViewById(R.id.usernameTV);
    }

    public TextView getUsernameTV() {
        return usernameTV;
    }
}
