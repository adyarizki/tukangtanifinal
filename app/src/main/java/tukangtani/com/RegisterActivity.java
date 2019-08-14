package tukangtani.com;

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

public class RegisterActivity extends AppCompatActivity {

    private EditText mViewUser, mViewPassword, mViewRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mViewUser = findViewById(R.id.emailSignUp);
        mViewPassword = findViewById(R.id.passwordSignUp);
        mViewRePassword = findViewById(R.id.rePasswordSignUp);

        mViewRePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });
    }

    private void razia(){
        mViewUser.setError(null);
        mViewPassword.setError(null);
        mViewRePassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        String repassword = mViewRePassword.getText().toString();
        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();

        if(TextUtils.isEmpty(user)){
            mViewUser.setError("This field is Required");
            fokus = mViewUser;
            cancel = true;
        }else if(cekUser(user)){
            mViewUser.setError("This Username is already exist");
            fokus = mViewUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This field is required");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password,repassword)){
            mViewRePassword.setError("This password is incorrect");
            fokus = mViewRePassword;
            cancel = true;
        }

        if (cancel){
            fokus.requestFocus();
        }else {
            Preferences.setRegisteredUser(getBaseContext(),user);
            Preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }
    }

    private boolean cekPassword(String password, String repassword){
        return password.equals(repassword);
    }

    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
