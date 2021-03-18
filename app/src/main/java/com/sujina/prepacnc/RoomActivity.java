package com.sujina.prepacnc;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sujina.prepacnc.adapters.RecyclerAdapterRoom;
import com.sujina.prepacnc.models.RecyclerDataRoom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    RecyclerView coursesRecyclerView;
    RecyclerAdapterRoom adapterRoom;
    ImageView roomIconV;
    int coursesNbr,roomIconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        // in the action bar
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        getSupportActionBar().setDisplayShowTitleEnabled(false);  // hide the title action bar
        // set the roomIcon
        roomIconV = (ImageView) findViewById(R.id.roomIcon);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            roomIconV.setImageResource(extras.getInt("roomIcon"));
            roomIconn = extras.getInt("roomIcon");
        }

        // set for the recycler
        List<RecyclerDataRoom> dataRoomList = new ArrayList<>(); // list of data of courses years, and israttra
        coursesNbr = 0;
        for (int i = 2020; i >2010 ; i--) {
            coursesNbr += 2;
            dataRoomList.add(new RecyclerDataRoom(Integer.toString(i), "0"));
            dataRoomList.add(new RecyclerDataRoom(Integer.toString(i), "1"));
        }
        // set the nbr of courses
        TextView coursesNbrRoom = (TextView) findViewById(R.id.circle_course_nbr);
        String coursesNbrS = Integer.toString(coursesNbr);
        coursesNbrRoom.setText(coursesNbrS);
        // set the new list data in the adapter
        setRoomRecycler(dataRoomList);
    }
    // set recycler
    private void setRoomRecycler(List<RecyclerDataRoom> dataRoomList){
        coursesRecyclerView = findViewById(R.id.recycler_room);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        coursesRecyclerView.setLayoutManager(layoutManager);
        adapterRoom = new RecyclerAdapterRoom(this,dataRoomList,roomIconn);
        coursesRecyclerView.setAdapter(adapterRoom);
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