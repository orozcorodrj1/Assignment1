package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationPage extends AppCompatActivity {
    private EditText regDob;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        Button controlButton = (Button) findViewById(R.id.btn_Reg);
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control();
            }
        });

        Button mForgetPassword = (Button) findViewById(R.id.btn_forgetpassword_MA);

        Button quit = (Button) findViewById(R.id.btn_back);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        regDob = (EditText)findViewById(R.id.Reg_Dob);
        regDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
            }
        });


    }




    void control(){

        EditText d2;
        d2 = (EditText)findViewById(R.id.Reg_Email);
        if (!d2.getText().toString().contains(getResources().getString(R.string.emailcheck)))
        {
            Toast.makeText(this.getBaseContext(),"This is not a valid e-mail address", Toast.LENGTH_LONG).show();
            return;}

        if (!isEditTextContainEmail(d2)){
            Toast.makeText(this.getBaseContext(),"Incorrect E-Mail Address!", Toast.LENGTH_LONG).show();
            return;}


        AlertDialog.Builder builder1 = new AlertDialog.Builder(RegistrationPage.this);
        builder1.setCancelable(true);
        builder1.setTitle("Thank you");
        builder1.setMessage("Registration Successful");
        builder1.setPositiveButton("Dismiss",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {



                    }
                });
        builder1.setNegativeButton("",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {

                        dialog.dismiss();


                    }
                });
        AlertDialog alert1 = builder1.create();
        alert1.show();

        return;
    }


    public static boolean isEditTextContainEmail(EditText argEditText) {

        try {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(argEditText.getText().toString().trim());
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        regDob.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



}


