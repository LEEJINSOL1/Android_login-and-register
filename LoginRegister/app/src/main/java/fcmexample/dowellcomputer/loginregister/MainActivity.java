package fcmexample.dowellcomputer.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        TextView email_Text = (TextView)findViewById(R.id.user_email);
        TextView passwordid_Text = (TextView)findViewById(R.id.user_password);
        TextView name_Text = (TextView)findViewById(R.id.user_name);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다. " +  userID + "님";

        email_Text.setText(userID);
        passwordid_Text.setText("당신의 비밀번호는 : " + userPassword);
        name_Text.setText(message);
        */

    }




}