package tukangtani.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class ViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.view.ViewPager viewPager = (android.support.v4.view.ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPageAdapter(this));


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MenuUtama.class));
            finish();
        }
    }

    public void pindah(View view){
        Intent intent = new Intent(ViewPager.this, LoginActivity.class);
        startActivity(intent);
    }

}
