package fcmexample.dowellcomputer.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NONE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_o_n_e);

        TextView txt = (TextView)findViewById(R.id.textView1);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        txt.setText("환영합니다. " + userID + "님!");
    }
}