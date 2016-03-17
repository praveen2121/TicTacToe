package com.example.praveen.project4tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Praveen on 2/26/2016.
 */
public class splash extends Activity {


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Thread t=new Thread()
        {

            public void run()
            {

                try {

                    sleep(3000);

                    Intent cv=new Intent(splash.this,MainActivity.class/*otherclass*/);
                    startActivity(cv);
                    finish();
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
