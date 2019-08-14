package tukangtani.com;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

 /* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/
public class MyApplication extends Application {

    public void onCreate(){
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration =new RealmConfiguration.Builder()
                .name("teman.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
