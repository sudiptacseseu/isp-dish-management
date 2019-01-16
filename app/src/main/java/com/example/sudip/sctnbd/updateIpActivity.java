package com.example.sudip.sctnbd;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class updateIpActivity extends AppCompatActivity implements View.OnClickListener{
    MyDatabaseHelper myDatabaseHelper;

    private EditText idEditText,ipEditText;
    private TextView update_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        setContentView(R.layout.activity_update_ip);

        idEditText = findViewById(R.id.id_editText_Id);
        ipEditText = findViewById(R.id.ip_editText_Id);
        update_info = findViewById(R.id.update_info_id);

        update_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String id = idEditText.getText().toString();
        String ip = ipEditText.getText().toString();

        if(view.getId() == R.id.update_info_id){
            Boolean isUpdated = myDatabaseHelper.updateIP(id,ip);

            if (isUpdated == true) {
                Toast.makeText(getApplicationContext(), "Data is successfully updated!",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(getApplicationContext(), "Data is not updated!",Toast.LENGTH_LONG).show();
            }

        }

    }
}
