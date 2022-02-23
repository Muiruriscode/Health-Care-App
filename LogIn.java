package com.example.kevin.nextgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Activity implements View.OnClickListener{
    Button bSignIn,bLogIn;
    EditText passwordEdit, usernameEdit;
    DatabaseHelper dHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medlogin);
        usernameEdit = (EditText) findViewById(R.id.etusernamelog);
        passwordEdit = (EditText) findViewById(R.id.etpasswordlog);
        bLogIn = (Button) findViewById(R.id.loginbutton);
        bSignIn = (Button) findViewById(R.id.signupbutton);

        bLogIn.setOnClickListener(this);
        bSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginbutton:
             String str = usernameEdit.getText().toString();
             String pass = passwordEdit.getText().toString();
//potential problem str vs pass
                String password = dHelper.searchPass(str);
                if(pass.equals(password)){
                    //main
                    Intent intent = new Intent(this, Display.class);
                    intent.putExtra("Username", str);
                    startActivity(intent);
                }
else{
                    Toast tpass = Toast.makeText(this,"Username and passwords don't match", Toast.LENGTH_SHORT);
                    tpass.show();
                }

                break;
            case R.id.signupbutton:
                startActivity(new Intent(this, Register.class));
                break;
        }

    }}
