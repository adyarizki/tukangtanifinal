package tukangtani.com.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import tukangtani.com.LoginActivity;
import tukangtani.com.Preferences;
import tukangtani.com.R;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_home, container, false);

        View view= inflater.inflate(R.layout.fragment_home, container, false);

        Button btnlogout = (Button) view.findViewById(R.id.button_logoutMain);
        TextView txtAbout = (TextView) view.findViewById(R.id.about);

        txtAbout.setText("Passionate Android Programmer who loves to create awesome software mobile that work great. Future goals want to improve the ability to build mobile software to the expert level. I also love what i do");

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new Intent(getActivity().getBaseContext(), LoginActivity.class));

            }
        });return view;
    }
}
