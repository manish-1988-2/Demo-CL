package info.lamatricexiste.network.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.lamatricexiste.network.ActivityMain;
import info.lamatricexiste.network.R;

/**
 */
public class LoginAcitivity extends Activity {

    private EditText mobileNumberEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private String phoneNo;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initComponent();
    }

    private void initComponent() {
        mobileNumberEditText = (EditText) findViewById(R.id.mobileNoEditText);
        passwordEditText = (EditText) findViewById(R.id.pswrdEditText);
        loginButton = (Button) findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo = mobileNumberEditText.getText().toString();
                password = passwordEditText.getText().toString();
                if (phoneNo.equals("") || password.equals("")) {
                    Toast.makeText(LoginAcitivity.this, "Please enter Mobile Number and Password...", Toast.LENGTH_SHORT).show();
                } else if (phoneNo.equals(GlobalSettings.USER1_PH_NO) && password.equals(GlobalSettings.USER1_PSSWORD)) {
                    Intent i = new Intent(LoginAcitivity.this, ActivityMain.class);
                    startActivity(i);

                } else if (phoneNo.equals(GlobalSettings.USER2_PH_NO) && password.equals(GlobalSettings.USER2_PSSWORD)) {
                    Intent i = new Intent(LoginAcitivity.this, ActivityMain.class);
                    startActivity(i);

                } else if (phoneNo.equals(GlobalSettings.USER3_PH_NO) && password.equals(GlobalSettings.USER3_PSSWORD)) {
                    Intent i = new Intent(LoginAcitivity.this, ActivityMain.class);
                    startActivity(i);

                } else if (phoneNo.equals(GlobalSettings.USER4_PH_NO) && password.equals(GlobalSettings.USER4_PSSWORD)) {
                    Intent i = new Intent(LoginAcitivity.this, ActivityMain.class);
                    startActivity(i);

                } else if (phoneNo.equals(GlobalSettings.USER5_PH_NO) && password.equals(GlobalSettings.USER5_PSSWORD)) {
                    Intent i = new Intent(LoginAcitivity.this, ActivityMain.class);
                    startActivity(i);

                } else {
                    Toast.makeText(LoginAcitivity.this, "Please enter valid Mobile Number and Password...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
