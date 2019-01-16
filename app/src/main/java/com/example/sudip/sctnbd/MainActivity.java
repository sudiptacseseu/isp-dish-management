package com.example.sudip.sctnbd;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView ispCardView,dishCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        ispCardView = findViewById(R.id.ispCardViewId);
        dishCardView = findViewById(R.id.dishCardViewId);

        ispCardView.setOnClickListener(this);
        dishCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.ispCardViewId){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);

        }else if(view.getId()==R.id.dishCardViewId){
            Intent intent = new Intent(MainActivity.this,Home2Activity.class);
            startActivity(intent);

        }

    }
}
