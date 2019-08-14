package tukangtani.com;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import java.util.List;

import tukangtani.com.Fragment.DetailFragment;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.MyViewHolder> {
    private List<TemanModel> temanModel;
    Context context;
    FragmentManager fragmentManager;


    public TemanAdapter(Context context, List<TemanModel> temanModel){
        this.context = context;
        this.temanModel = temanModel;
    }

    @Override
    public TemanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman, parent, false);

        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(TemanAdapter.MyViewHolder holder, int position) {
        final TemanModel model = temanModel.get(position);
        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.telepon.setText(model.getTelepon());
        holder.email.setText(model.getEmail());
        holder.sosmed.setText(model.getSosmed());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                Fragment fragment = new DetailFragment();
                data.putInt("id",model.getId());
                data.putString("nim",model.getNim().toString());
                data.putString("nama",model.getNama());
                data.putString("kelas",model.getKelas());
                data.putString("telepon",model.getTelepon());
                data.putString("email",model.getEmail());
                data.putString("sosmed",model.getSosmed());
                fragment.setArguments(data);

                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();//now replace the argument fragment

            }
        });
    }

    @Override
    public int getItemCount() {
        return temanModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, telepon, email, sosmed;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            telepon = itemView.findViewById(R.id.tvTelepon);
            email = itemView.findViewById(R.id.tvEmail);
            sosmed = itemView.findViewById(R.id.tvSosmed);
        }
    }
}

