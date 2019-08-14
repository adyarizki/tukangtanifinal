package tukangtani.com.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tukangtani.com.R;
import tukangtani.com.RealmHelper;
import tukangtani.com.TemanModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class TambahFragment extends Fragment implements View.OnClickListener {

    Button btnSimpan, btnTampil;
    EditText nim, nama, kelas, telepon, email, sosmed;
    String   sNama, sKelas, sTelepon, sEmail, sSosmed;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    TemanModel temanModel;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_tambah, container, false);
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);

        btnSimpan = view.findViewById(R.id.btnSimpan);
        btnTampil = view.findViewById(R.id.btnTampil);
        nim = view.findViewById(R.id.nim);
        nama = view.findViewById(R.id.nama);
        kelas = view.findViewById(R.id.kelas);
        telepon = view.findViewById(R.id.telepon);
        email = view.findViewById(R.id.email);
        sosmed = view.findViewById(R.id.sosmed);

        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);


        return view;
    }
    @Override
    public void onClick (View v){
        if (v == btnSimpan) {
            if ((nim.getText().toString().length() < 1) || (nim.getText().toString().length() > 8)){
                nim.setError("Masukan Nim");
            }else if (nama.getText().toString().length() ==0 ){
                nama.setError("Masukan nama");
            }else if(kelas.getText().toString().length() ==0){
                kelas.setError("Masukan Kelas");
            }else if(telepon.getText().toString().length() ==0){
                telepon.setError("Masukan Nomer Telepon");
            }else if(email.getText().toString().length() ==0){
                email.setError("Masukan Email");
            }else if(sosmed.getText().toString().length() ==0){
                sosmed.setError("Masukan Akun Sosmed");
            }
            else {
                sNim = Integer.parseInt(nim.getText().toString());
                sNama = nama.getText().toString();
                sKelas = kelas.getText().toString();
                sTelepon = telepon.getText().toString();
                sEmail = email.getText().toString();
                sSosmed = sosmed.getText().toString();

                if (!sNim.equals("") && !sNama.isEmpty() && !sKelas.isEmpty() && !sTelepon.isEmpty() && !sEmail.isEmpty() && !sSosmed.isEmpty()) {
                    temanModel = new TemanModel();
                    temanModel.setNim(sNim);
                    temanModel.setNama(sNama);
                    temanModel.setKelas(sKelas);
                    temanModel.setTelepon(sTelepon);
                    temanModel.setEmail(sEmail);
                    temanModel.setSosmed(sSosmed);


                    realmHelper = new RealmHelper(realm);
                    realmHelper.save(temanModel);

                    Toast.makeText(this.getActivity(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                    nim.setText("");
                    nama.setText("");
                    kelas.setText("");
                    telepon.setText("");
                    email.setText("");
                    sosmed.setText("");
                }
            }
        } else if (v == btnTampil) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment()).commit();
        } else if( nim.length() ==0 ){
            nim.setError("rdgf");
        }
    }
}
