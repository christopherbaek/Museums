package com.cbaek.museums;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
    }

    /**
     * Called when user clicks "What Should I Do?" button
     *
     * @param view
     */
    public void openMuseumActivity(final View view) {
        final Intent museumActivityIntent = new Intent(this, MuseumActivity.class);
        startActivity(museumActivityIntent);
    }

}
