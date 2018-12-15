package com.malik.usman.findmobileapp;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    public static final String MY_PREFS_NAME="mypresfile";
    EditText edt_name,edt_pass,edt_disply;
    Button btn_save,btn_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = findViewById(R.id.edit_name);
        edt_pass = findViewById(R.id.edit_pass);
        btn_save = findViewById(R.id.btn_snd);
        btn_display=findViewById(R.id.btn_disply);
        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(null);
            }
        });
        edt_disply = findViewById(R.id.edt_dispply);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(null);
            }
        });
    }

    public void save(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE).edit();
        editor.putString("name",edt_name.getText().toString());
        editor.putString("password",edt_pass.getText().toString());
        editor.apply();
        Toast.makeText(this, "Data Save SuccessFully", Toast.LENGTH_SHORT).show();

    }
    public void display(View view){
        SharedPreferences preferences=getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        String name=preferences.getString("name",edt_name.getText().toString());
        String pass=preferences.getString("password",edt_pass.getText().toString());
        edt_disply.setText(name+""+pass);
        Toast.makeText(this, "Data show", Toast.LENGTH_SHORT).show();
    }
}
