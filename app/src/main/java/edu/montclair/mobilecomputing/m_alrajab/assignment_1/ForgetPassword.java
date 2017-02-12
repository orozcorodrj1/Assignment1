package edu.montclair.mobilecomputing.m_alrajab.assignment_1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ForgetPassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        findViewById(R.id.btn_back1).setOnClickListener(new MyLsnr());;

    }


    class MyLsnr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_back1) {
                Intent intent=new Intent(ForgetPassword.this, MainActivity.class);
                startActivity(intent);
            }

        }
    }
}
