package tukangtani.com.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tukangtani.com.R;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_contact, container, false);
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button btnphone = (Button) view.findViewById(R.id.btnTelepon);
        Button btnins = (Button) view.findViewById(R.id.btnInstagram);
        Button btnfb = (Button) view.findViewById(R.id.btnFacebook);
        Button btngmail = (Button) view.findViewById(R.id.btnEmail);

        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.nomeradi);
                String dial = "tel:" + phone;
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
                startActivity(intent);
            }
        });
        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlfb ="https://www.facebook.com/ady.rizki.39";
                Intent bukafb=new Intent(Intent.ACTION_VIEW);
                bukafb.setData(Uri.parse(urlfb));
                startActivity(bukafb);
            }
        });
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Menyapa");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hai, Ady.");
                emailIntent.setData(Uri.parse("mailto:adyaprilriyanrizki@gmail.com"));
                startActivity(Intent.createChooser(emailIntent, "Send feedback"));
            }
        });
        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlig ="https://www.instagram.com/daun_kalapa";
                Intent bukaig=new Intent(Intent.ACTION_VIEW);
                bukaig.setData(Uri.parse(urlig));
                startActivity(bukaig);
            }
        });
        return view;
    }
}
