package com.example.shitalbharatlondhe.sqlitedemo;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentLogin extends AppCompatActivity {

    Button Login;
    EditText uid, upass;
    DataHelper dh;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_student);


        uid = (EditText)findViewById(R.id.edtUserName);
        upass = (EditText)findViewById(R.id.edtPassword);

        Login = (Button)findViewById(R.id.btnLogin);

        dh = new DataHelper(this);


        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub

                String user = uid.getText().toString();
                String pass = upass.getText().toString();

                Boolean result = dh.logintabelcheck(user, pass);

                if(result)
                {
                    Intent stu = new Intent(StudentLogin.this, MainActivity.class);
                    startActivity(stu);
//                    System.out.println(result);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_LONG).show();
                }




            }
        });



    }

}
