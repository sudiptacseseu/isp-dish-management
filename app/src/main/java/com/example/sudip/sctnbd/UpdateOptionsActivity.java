package com.example.sudip.sctnbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class UpdateOptionsActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView updateUserContactCardView,updateUserIPCardView,updatePaymentCardView,updateAllInfoCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_options);
        getSupportActionBar().hide();

        updateUserContactCardView = findViewById(R.id.updateUserContactCardViewId);
        updateUserIPCardView = findViewById(R.id.updateUserIPCardViewId);
        updatePaymentCardView = findViewById(R.id.updatePaymentCardViewId);
        updateAllInfoCardView = findViewById(R.id.updateAllInfoCardViewId);

        updateUserContactCardView.setOnClickListener(this);
        updateUserIPCardView.setOnClickListener(this);
        updatePaymentCardView.setOnClickListener(this);
        updateAllInfoCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.updateUserContactCardViewId) {
            Intent intent = new Intent(UpdateOptionsActivity.this, updateContactActivity.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.updateUserIPCardViewId) {
            Intent intent = new Intent(UpdateOptionsActivity.this, updateIpActivity.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.updatePaymentCardViewId) {
            Intent intent = new Intent(UpdateOptionsActivity.this, updatePaymentActivity.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.updateAllInfoCardViewId) {
            Intent intent = new Intent(UpdateOptionsActivity.this, updateInfo_Activity.class);
            startActivity(intent);

        }
    }
}
