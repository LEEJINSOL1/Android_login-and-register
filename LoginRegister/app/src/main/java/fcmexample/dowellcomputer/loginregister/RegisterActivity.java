package fcmexample.dowellcomputer.loginregister;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.Thread.sleep;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       final EditText idText = (EditText)findViewById(R.id.email_register_et);
       final EditText passText = (EditText)findViewById(R.id.password_register_et);
       final EditText nameText = (EditText)findViewById(R.id.name_register_et);
       final Button register_btn = (Button)findViewById(R.id.btn_register_finish);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = idText.getText().toString();
                String userPassword = passText.getText().toString();
                String userName = nameText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                //AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                //builder.setMessage("회원등록에 성공하였습니다.").setPositiveButton("확인",null).create().show();
                                Toast.makeText(RegisterActivity.this,"회원가입이 완료되었습니다. " , LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                              //  AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                //builder.setMessage("회원등록에 실패하였습니다.").setNegativeButton("확인",null).create().show();
                                Toast.makeText(RegisterActivity.this,"회원가입에 실패하였습니다. " , LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID, userPassword,userName,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}