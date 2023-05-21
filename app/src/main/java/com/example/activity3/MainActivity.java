package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton insert_btn;
    AppCompatButton view_btn;
    AppCompatButton delete_btn;
    EditText u_name;
    EditText u_ph;
    EditText u_Dname;
    contact c = new contact();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initcomponents();
        settinguplistners();
        deletestuff();
        updatestuff();
    }

    private void updatestuff() {
         contact c = new contact();
         c.setId(1);
         c.setName("CHANGED NAME");
         c.setPh_no("000000000");
        DBHelper dbHelper = new DBHelper(this);
        int affectedrow = dbHelper.update(c);

    }

    private void deletestuff() {
        delete_btn.setOnClickListener(view->{
            if(!u_Dname.getText().toString().isEmpty())
            {
                String todelete = u_Dname.getText().toString();

                DBHelper dbHelper = new DBHelper(this);
                dbHelper.delete(todelete);
                Toast.makeText(this, "Deleted SuccessFully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Put Something", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void settinguplistners() {
        insert_btn.setOnClickListener(view -> {
            if(!u_name.getText().toString().isEmpty()
            && !u_ph.getText().toString().isEmpty())
            {
                c.setName(u_name.getText().toString());
                c.setPh_no(u_ph.getText().toString());
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                DBHelper dbHelper = new DBHelper(this);
                boolean b = dbHelper.insert(c);

                if(b)
                {
                    Log.d("SQLDB","insert success");
                }
                else
                {
                    Log.d("SQLDB","insert success NOT");

                }
            }
        });
        view_btn.setOnClickListener(view ->{
           Intent intent = new Intent(MainActivity.this, viewcontents.class);
           startActivity(intent);
        });

    }

    private void initcomponents() {
        u_name = findViewById(R.id.name);
        u_ph=findViewById(R.id.phone);
        u_Dname = findViewById(R.id.delete);
        insert_btn = findViewById(R.id.i_btn);
        view_btn = findViewById(R.id.v_btn);
        delete_btn = findViewById(R.id.d_btn);

    }
}







