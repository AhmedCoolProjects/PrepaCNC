package com.sujina.prepacnc.ui.profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;
import com.sujina.prepacnc.LoginActivity;
import com.sujina.prepacnc.R;

public class ProfileFragment extends Fragment {
TextView user_email,user_name;
ImageView user_image;
LinearLayout logout_btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        // infos
        user_email = (TextView) root.findViewById(R.id.user_email);
        user_name = (TextView) root.findViewById(R.id.user_name);
        user_image = (ImageView) root.findViewById(R.id.user_image);
        logout_btn = (LinearLayout) root.findViewById(R.id.log_btn);
        // call google infos
        GoogleSignInAccount googleSignInAccount;
        googleSignInAccount = GoogleSignIn.getLastSignedInAccount(getContext());
        if (googleSignInAccount!=null){
            user_name.setText(googleSignInAccount.getDisplayName());
            user_email.setText(googleSignInAccount.getEmail());
            Picasso.get().load(googleSignInAccount.getPhotoUrl()).into(user_image);
        }
        // end infos
        // log out
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                // Google sign out
                GoogleSignIn.getClient(getContext(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()).signOut();
                Toast.makeText(getContext(), "LogOut", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                user_name.setText("");
                user_email.setText("");
                user_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_logo));
            }
        });
        // end log out
        return root;
    }
}