package com.example.sudip.sctnbd;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deleteUser2_Activity extends AppCompatActivity implements View.OnClickListener {
    MyDatabaseHelper2 myDatabaseHelper;

    private EditText idEditText;
    private TextView delete_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        myDatabaseHelper = new MyDatabaseHelper2(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        setContentView(R.layout.activity_delete_user2);

        idEditText = findViewById(R.id.id_editText_Id);
        delete_user = findViewById(R.id.delete_user_id);
        delete_user.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String id = idEditText.getText().toString();

        if(view.getId() == R.id.delete_user_id)
        {
            int value = myDatabaseHelper.deleteData(id);
            if(value>0){
                Toast.makeText(getApplicationContext(), "Data is deleted",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(getApplicationContext(), "Data is not deleted!",Toast.LENGTH_LONG).show();

            }

        }

    }
}
