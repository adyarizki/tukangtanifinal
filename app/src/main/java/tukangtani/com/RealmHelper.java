package tukangtani.com;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

 /* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm){
        this.realm=realm;
    }

    public void save(final TemanModel temanModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(TemanModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    temanModel.setId(nextId);
                    TemanModel model = realm.copyToRealm(temanModel);
                }else{
                    Log.e("ppppp", "execute : Database not Exist");
                }
            }
        });
    }
    public List<TemanModel> getAllTeman(){
        RealmResults<TemanModel> results= realm.where(TemanModel.class).findAll();
        return results;
    }

    // To update data from database
    public void update(final Integer id, final Integer nim, final String nama, final String kelas, final String telepon, final String email, final String sosmed){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TemanModel model = realm.where(TemanModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
                model.setKelas(kelas);
                model.setTelepon(telepon);
                model.setEmail(email);
                model.setSosmed(sosmed);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }
    public void delete(Integer id){
        final RealmResults<TemanModel> model = realm.where(TemanModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
