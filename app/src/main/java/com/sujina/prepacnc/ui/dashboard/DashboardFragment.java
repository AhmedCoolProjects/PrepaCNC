package com.sujina.prepacnc.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sujina.prepacnc.R;
import com.sujina.prepacnc.RoomActivity;

public class DashboardFragment extends Fragment {
    LinearLayout siiL,pythonL,mathsL,physicsL,chimieL;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // associate cards
        mathsL = (LinearLayout) root.findViewById(R.id.card_maths);
        physicsL = (LinearLayout) root.findViewById(R.id.card_physics);
        chimieL = (LinearLayout) root.findViewById(R.id.card_chimie);
        siiL = (LinearLayout) root.findViewById(R.id.card_sii);
        pythonL = (LinearLayout) root.findViewById(R.id.card_python);
        // create the intent to redirect
        Intent roomIntent = new Intent(getActivity(),RoomActivity.class);
        // maths
        mathsL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomIntent.putExtra("roomIcon",R.drawable.ic_maths_icon);
                startActivity(roomIntent);
            }
        });
        // physics
        physicsL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomIntent.putExtra("roomIcon",R.drawable.ic_physics_icon);
                startActivity(roomIntent);
            }
        });
        // chimie
        chimieL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomIntent.putExtra("roomIcon",R.drawable.ic_chimie_icon);
                startActivity(roomIntent);
            }
        });
        // sii
        siiL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomIntent.putExtra("roomIcon",R.drawable.ic_sii_icon);
                startActivity(roomIntent);
            }
        });
        // python
        pythonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomIntent.putExtra("roomIcon",R.drawable.ic_python_icon);
                startActivity(roomIntent);
            }
        });
        return root;
    }
}