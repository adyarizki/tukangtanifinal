package tukangtani.com;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

 /* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        //menjalanakan splash activity dalam beberapa detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //apa yang terjadi
                Intent intent = new Intent(Splash_Screen.this, ViewPager.class);
                startActivity(intent);
                //splash hilang
                finish();
            }
        }, 3000);
    }
}
