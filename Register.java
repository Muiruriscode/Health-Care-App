package com.example.kevin.nextgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity implements View.OnClickListener{
    Button signUpReg;


    DatabaseHelper helper =new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        signUpReg = (Button) findViewById(R.id.signupreg);
        signUpReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            EditText etName = (EditText) findViewById(R.id.nameedit);
            EditText etEmail = (EditText) findViewById(R.id.emedit);
            EditText etUserName = (EditText) findViewById(R.id.unameedit);
            EditText etPassword = (EditText) findViewById(R.id.Passwordregedit);
            EditText etConfirmPassword = (EditText) findViewById(R.id.ConfirmPasswordedit);


            String namestr = etName.getText().toString();
            String emailstr = etEmail.getText().toString();
            String unamestr = etUserName.getText().toString();
            String passstr = etPassword.getText().toString();
            String cfmpassstr = etConfirmPassword.getText().toString();
        if((!cfmpassstr.equals(passstr))){
            Toast pass = Toast.makeText(Register.this,"passwords don't match", Toast.LENGTH_SHORT);
            pass.show();
        }
        else{
            //Insert details in database
            Contact cont = new Contact();
            cont.setName(namestr);
            cont.setEmail(emailstr);
            cont.setUname(unamestr);
            cont.setPass(passstr);

           helper.insertContact(cont);
            Toast zpass = Toast.makeText(Register.this,"signup successful", Toast.LENGTH_SHORT);
            zpass.show();
            //startActivity(new Intent(this,MainActivity.class));

}
    }
}
