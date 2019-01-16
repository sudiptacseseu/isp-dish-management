package com.example.sudip.sctnbd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FeedBack_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView sendButton, clearButton;
    private EditText emailEditText, passwordEditText,messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_);

        getSupportActionBar().hide();

        sendButton = findViewById(R.id.sendButtonId);
        clearButton = findViewById(R.id.clearButton_id);

        emailEditText = findViewById(R.id.editText1_Id);
        passwordEditText = findViewById(R.id.editText2_Id);
        messageEditText = findViewById(R.id.editText3_Id);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try{
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if(view.getId()== R.id.sendButtonId){

                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sudiptacse.seu@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Email: "+email +"\nPassword: "+password +"\nMessage: "+message);

                startActivity(Intent.createChooser(intent, "Feedback with: "));

            }else if(view.getId()== R.id.clearButton_id){

                emailEditText.setText("");
                passwordEditText.setText("");
                messageEditText.setText("");
            }

        }catch(Exception e){

            Toast.makeText(getApplicationContext(),"Exception :"+e,Toast.LENGTH_LONG).show();

        }



    }
}
