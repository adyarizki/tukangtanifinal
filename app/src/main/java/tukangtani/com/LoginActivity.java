package tukangtani.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/* NIM   : 10116107
 *  Nama  : Ady Aprilriyan Rizki
 *  Kelas : AKB-3 / IF3
 *  Tanggla Pengerjaan : 09/08/2019*/

public class LoginActivity extends AppCompatActivity {

    private EditText mViewUser, mViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       mViewUser = findViewById(R.id.emailSignIn);
       mViewPassword = findViewById(R.id.passwordSignIn);

       mViewPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL){
                   razia();
                   return true;
               }
               return false;
           }
       });

       findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               razia();
           }
       });

       findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getBaseContext(),RegisterActivity.class));
           }
       });
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (Preferences.getLoggedInStatus(getBaseContext())) {
//            startActivity(new Intent(getBaseContext(), MenuUtama.class));
//            finish();
//            Toast.makeText(this, "ngetes wa", Toast.LENGTH_SHORT).show();
//
//        }
//    }


    private void razia() {

        mViewUser.setError(null);
        mViewPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();

        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This Field Is Required");
            fokus = mViewUser;
            cancel = true;
        }else if(!cekUser(user)){
            mViewUser.setError("This Username is Not Found");
            fokus = mViewUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This Field Is Required");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password)){
            mViewPassword.setError("This Field Is Required");
            fokus = mViewPassword;
            cancel = true;
        }

        if (cancel) fokus.requestFocus();
        else masuk();
    }

    private void masuk(){
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),MenuUtama.class));finish();
    }

    private boolean cekPassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
