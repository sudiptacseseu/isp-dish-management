package com.example.sudip.sctnbd;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class updatePayment2Activity extends AppCompatActivity implements View.OnClickListener{
    MyDatabaseHelper2 myDatabaseHelper;

    String[] spinner_options;

    private EditText idEditText,dateEditText;
    private TextView update_info;
    private Spinner spinner;
    private Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        myDatabaseHelper = new MyDatabaseHelper2(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        setContentView(R.layout.activity_update_payment2);

        spinner_options = getResources().getStringArray(R.array.spinner_options);

        myCalendar = Calendar.getInstance();

        idEditText = findViewById(R.id.id_editText_Id);
        spinner = findViewById(R.id.status_editText_Id);
        dateEditText = findViewById(R.id.date_editText_Id);
        update_info = findViewById(R.id.update_info_id);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spinner_options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        update_info.setOnClickListener(this);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }


        };


        dateEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(updatePayment2Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onClick(View view) {

        String id = idEditText.getText().toString();
        String status = spinner.getSelectedItem().toString();
        String date = dateEditText.getText().toString();

        if(view.getId() == R.id.update_info_id){
            Boolean isUpdated = myDatabaseHelper.updatePayment(id,status,date);

            if (isUpdated == true) {
                Toast.makeText(getApplicationContext(), "Data is successfully updated!",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(getApplicationContext(), "Data is not updated!",Toast.LENGTH_LONG).show();
            }

        }

    }
}
