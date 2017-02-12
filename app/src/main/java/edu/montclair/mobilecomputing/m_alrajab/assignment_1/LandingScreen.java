package edu.montclair.mobilecomputing.m_alrajab.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class LandingScreen extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 3000; // time to display the splash screen in ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                } finally {

                    startActivity(new Intent(LandingScreen.this,
                            MainActivity.class));
                    finish();
                }
            };
        };
        splashTread.start();

    }
}
