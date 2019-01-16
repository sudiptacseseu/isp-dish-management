package com.example.sudip.sctnbd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView adduserCardView,displayallCardView,updateCardView,duebillCardView,delete_userCardView,total_dueCardView;

    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adduserCardView = findViewById(R.id.addUserCardViewId);
        displayallCardView = findViewById(R.id.displayallCardViewId);
        updateCardView = findViewById(R.id.updateCardViewId);
        duebillCardView = findViewById(R.id.duebillCardViewId);
        delete_userCardView = findViewById(R.id.deleteUserCardViewId);
        total_dueCardView = findViewById(R.id.totaldueCardViewId);


        adduserCardView.setOnClickListener(this);
        displayallCardView.setOnClickListener(this);
        updateCardView.setOnClickListener(this);
        duebillCardView.setOnClickListener(this);
        delete_userCardView.setOnClickListener(this);
        total_dueCardView.setOnClickListener(this);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==R.id.feedbackId){

            Intent intent = new Intent(getApplicationContext(),FeedBack_Activity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.contactusId){

            Intent intent = new Intent(getApplicationContext(),ContactUsActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.logout_Id){

            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
        public void onClick(View view) {



        if (view.getId() == R.id.addUserCardViewId) {
            Intent intent = new Intent(HomeActivity.this, addUser_Activity.class);
            startActivity(intent);

        }


        if (view.getId() == R.id.displayallCardViewId) {
            Cursor cursor = myDatabaseHelper.displayallData();
            if (cursor.getCount() == 0) {

                showData("Error", "No data found!!");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()) {

                stringBuffer.append("ID : " + cursor.getString(0) + "\n");
                stringBuffer.append("NAME : " + cursor.getString(1) + "\n");
                stringBuffer.append("CONTACT : " + cursor.getString(2) + "\n");
                stringBuffer.append("ADDRESS : " + cursor.getString(3) + "\n");
                stringBuffer.append("BANDWIDTH : " + cursor.getString(4) + "\n");
                stringBuffer.append("TAKA : " + cursor.getString(5) + "\n");
                stringBuffer.append("IP : " + cursor.getString(6) + "\n");
                stringBuffer.append("STATUS : " + cursor.getString(7) + "\n");
                stringBuffer.append("DATE : " + cursor.getString(8) + "\n\n\n");
            }
            showData("User Details:", stringBuffer.toString());
        }


        if (view.getId() == R.id.updateCardViewId) {
            Intent intent = new Intent(HomeActivity.this, UpdateOptionsActivity.class);
            startActivity(intent);

        }


        if (view.getId() == R.id.duebillCardViewId) {
            Cursor cursor = myDatabaseHelper.displaydueData();
            if (cursor.getCount() == 0) {

                showData2("Error", "No data found!!");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()) {

                stringBuffer.append("ID : " + cursor.getString(0) + "\n");
                stringBuffer.append("NAME : " + cursor.getString(1) + "\n");
                stringBuffer.append("CONTACT : " + cursor.getString(2) + "\n");
                stringBuffer.append("ADDRESS : " + cursor.getString(3) + "\n");
                stringBuffer.append("BANDWIDTH : " + cursor.getString(4) + "\n");
                stringBuffer.append("TAKA : " + cursor.getString(5) + "\n");
                stringBuffer.append("IP : " + cursor.getString(6) + "\n");
                stringBuffer.append("STATUS : " + cursor.getString(7) + "\n");
                stringBuffer.append("DATE : " + cursor.getString(8) + "\n\n\n");
            }
            showData2("Due Details:", stringBuffer.toString());
        }

        if (view.getId() == R.id.totaldueCardViewId) {
            Cursor cursor = myDatabaseHelper.displaytotalDue();
            if (cursor.getCount() == 0) {

                showData3("Error", "No data found!!");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()) {
                stringBuffer.append(cursor.getString(0) + " Customers\n");
            }
            showData3("Total Due:", stringBuffer.toString());


        }

        if (view.getId() == R.id.deleteUserCardViewId) {
            Intent intent = new Intent(HomeActivity.this,deleteUser_Activity.class);
            startActivity(intent);
        }

    }

    public void showData (String title, String message){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setCancelable(true);
            builder.show();
        }

    private void showData2(String title2, String message2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title2);
            builder.setMessage(message2);
            builder.setCancelable(true);
            builder.show();
    }
    private void showData3(String title3, String message3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title3);
        builder.setMessage(message3);
        builder.setCancelable(true);
        builder.show();
    }
    }
