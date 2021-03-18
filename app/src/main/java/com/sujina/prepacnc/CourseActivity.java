package com.sujina.prepacnc;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CourseActivity extends AppCompatActivity {
    Integer position,year;
    String sujCorr,exRatt,courseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        // in the action bar
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            position = extras.getInt("position");
            year = 2020 - position/2;
            if (position%2 != 0){
                exRatt = "Rattrapage";
            }else {
                exRatt="Exam";
            }
            sujCorr = extras.getString("sujCorr");
            courseTitle = exRatt +" "+year+" "+sujCorr;
        }
        getSupportActionBar().setTitle(courseTitle);
        getSupportActionBar().setIcon(extras.getInt("roomIcon"));


    }
    // this override for the back functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}