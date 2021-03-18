package com.sujina.prepacnc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sujina.prepacnc.CourseActivity;
import com.sujina.prepacnc.R;
import com.sujina.prepacnc.models.RecyclerDataRoom;

import java.util.List;

public class RecyclerAdapterRoom extends RecyclerView.Adapter<RecyclerAdapterRoom.RoomHolder> {
    Context context;
    int roomIcon ;
    List<RecyclerDataRoom> DataRoomList;
    public RecyclerAdapterRoom(Context context, List<RecyclerDataRoom> dataRoomList,int roomIconR) {
        this.context = context;
        DataRoomList = dataRoomList;
        roomIcon = roomIconR;
    }
    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_item_room,parent,false);
        return new RoomHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
        holder.Course_year.setText(DataRoomList.get(position).getCourseYear());
        String isR = (String) DataRoomList.get(position).getIsRattrap();
        if (isR.equals("0")){
            holder.Course_irater.setText(R.string.sujet1_string);

        }else{
            holder.Course_irater.setText(R.string.rattrapage_string);

        }
        // clicking item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the intent to the course
                Intent courseIntent = new Intent(context, CourseActivity.class);
                //creating a popup menu
                PopupMenu popup = new PopupMenu(context,holder.itemView);
                //inflating menu from xml resource
                popup.inflate(R.menu.menu_course);
                // popup custom
                // ?????
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_item_1:
                                courseIntent.putExtra("position",position);
                                courseIntent.putExtra("sujCorr","Sujet");
                                courseIntent.putExtra("roomIcon",roomIcon);
                                context.startActivity(courseIntent);

                                return true;
                            case R.id.menu_item_2:
                                courseIntent.putExtra("position",position);
                                courseIntent.putExtra("sujCorr","Correction");
                                courseIntent.putExtra("roomIcon",roomIcon);
                                context.startActivity(courseIntent);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return DataRoomList.size();
    }
    public static final class RoomHolder extends RecyclerView.ViewHolder{
        TextView Course_year, Course_irater;

        public RoomHolder(@NonNull View itemView) {
            super(itemView);
            Course_year = (TextView) itemView.findViewById(R.id.course_year);
            Course_irater = (TextView) itemView.findViewById(R.id.course_israttra);
        }
    }
}
