package com.example.kevin.nextgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    DatabaseHelper dHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medlogin);

        Button bLogIn = (Button) findViewById(R.id.loginbutton);
        Button bSignIn = (Button) findViewById(R.id.signupbutton);

        bLogIn.setOnClickListener(MainActivity.this);
        bSignIn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.loginbutton) {
            EditText usernameEdit = (EditText) findViewById(R.id.etusernamelog);
            EditText passwordEdit = (EditText) findViewById(R.id.etpasswordlog);

            String str = usernameEdit.getText().toString();
            String pass = passwordEdit.getText().toString();
//potential problem str vs pass

            String password = dHelper.searchPass(str);
            if (pass.equals(password)) {
            //main
            startActivity(new Intent(MainActivity.this, Display.class));
            //mintent.putExtra("Username", str);

            }
            else{
             Toast tpass = Toast.makeText(MainActivity.this, "Username and passwords don't match", Toast.LENGTH_SHORT);
             tpass.show();
             }
             }
        else if (view.getId() == R.id.signupbutton) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        }
    }

