package com.example.sudip.sctnbd;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.sudip.sctnbd.MainActivity;
import com.example.sudip.sctnbd.R;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    TextView textView, textView2;
    EditText editText1, editText2;
    private int counter = 3;
    private AlertDialog.Builder aleartDialogBuilder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();

        textView = findViewById(R.id.login_id);
        textView2 = findViewById(R.id.attempt_status_id);
        editText1 = findViewById(R.id.editText1_Id);
        editText2 = findViewById(R.id.editText2_Id);
        textView2.setText("Number of attempts remaining: 3");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String username = editText1.getText().toString();
                    String password = editText2.getText().toString();
                    if (username.equals("SCTNBD") && password.equals("Shanuhar120")) {
                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        counter--;
                        textView2.setText("Number of attempts remaining: "+counter);
                        if (counter == 0) {
                            textView.setEnabled(false);
                        }

                    }
            }

        });
    }

    @Override
    public void onBackPressed() {

        aleartDialogBuilder = new AlertDialog.Builder(SignInActivity.this);

        aleartDialogBuilder.setTitle(R.string.aleart_title);

        aleartDialogBuilder.setMessage(R.string.aleart_message);

        aleartDialogBuilder.setIcon(R.drawable.question);
        aleartDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                    System.exit(0);
                }


            }
        });

        aleartDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        aleartDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SignInActivity.this,"You have clicked on Cancel button!",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = aleartDialogBuilder.create();
        alertDialog.show();


    }
}
