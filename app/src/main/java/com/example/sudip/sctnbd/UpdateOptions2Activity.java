package com.example.sudip.sctnbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class UpdateOptions2Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView updateUserContactCardView,updatePaymentCardView,updateAllInfoCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_options2);
        getSupportActionBar().hide();

        updateUserContactCardView = findViewById(R.id.updateUserContactCardViewId);
        updatePaymentCardView = findViewById(R.id.updatePaymentCardViewId);
        updateAllInfoCardView = findViewById(R.id.updateAllInfoCardViewId);

        updateUserContactCardView.setOnClickListener(this);
        updatePaymentCardView.setOnClickListener(this);
        updateAllInfoCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.updateUserContactCardViewId) {
            Intent intent = new Intent(UpdateOptions2Activity.this, updateContact2Activity.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.updatePaymentCardViewId) {
            Intent intent = new Intent(UpdateOptions2Activity.this, updatePayment2Activity.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.updateAllInfoCardViewId) {
            Intent intent = new Intent(UpdateOptions2Activity.this, updateInfo2_Activity.class);
            startActivity(intent);

        }
    }
}
