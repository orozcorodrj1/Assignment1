package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_forgetpassword_MA).setOnClickListener(new MyLsnr());;
        findViewById(R.id.btn_register_MA).setOnClickListener(new MyLsnr());;

    }



    class MyLsnr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_forgetpassword_MA) {
                Intent intent=new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
            if(view.getId() == R.id.btn_register_MA){
                Intent intent=new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(intent);
            }
        }
    }



}
