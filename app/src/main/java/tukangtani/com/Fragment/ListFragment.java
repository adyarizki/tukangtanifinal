package tukangtani.com.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import tukangtani.com.R;
import tukangtani.com.RealmHelper;
import tukangtani.com.TemanAdapter;
import tukangtani.com.TemanModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;

 /* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class ListFragment extends Fragment  /*implements View.OnClickListener*/ {

    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    TemanAdapter temanAdapter;
    List<TemanModel> temanModelList;
    Button btnTambah;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_tambah, container, false);
        View view = inflater.inflate(R.layout.activity_teman, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        btnTambah = view.findViewById(R.id.btnTambah);

        // Setup Realm
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        temanModelList = new ArrayList<>();

        temanModelList = realmHelper.getAllTeman();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TambahFragment()).commit();
            }
        });

        show();
        return view;
    }

    public void show() {
        temanAdapter = new TemanAdapter(getActivity(), temanModelList);
        recyclerView.setAdapter(temanAdapter);
    }
}
