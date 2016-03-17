package com.example.praveen.project4tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,b;
    Button[] bArray;
    TextView tv;

    Boolean turn=true;
    int turn_Count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

a1=(Button)findViewById(R.id.cell00);
        a2=(Button)findViewById(R.id.cell01);
        a3=(Button)findViewById(R.id.cell02);
        b1=(Button)findViewById(R.id.cell10);
        b2=(Button)findViewById(R.id.cell11);
        b3=(Button)findViewById(R.id.cell12);
        c1=(Button)findViewById(R.id.cell20);
        c2=(Button)findViewById(R.id.cell21);
        c3=(Button)findViewById(R.id.cell22);
        tv=(TextView)findViewById(R.id.Reset);


bArray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};



        for(  Button b:bArray){

            b.setOnClickListener(this);



        }


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn=true;
                turn_Count=0;
                enabledisable(true);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Button b=(Button) v;
        buttonClicked(b);


    }

public void buttonClicked(Button b){
if(turn){


    b.setText("X");

}

    else {

    b.setText("O");

    }


    turn_Count++;

    b.setClickable(false);
turn=!turn;
    checkForWinner();
}

    public void enabledisable(boolean enable){

        for(Button b:bArray){


            b.setClickable(enable);

if(enable==true){

    b.setText("");
}

        }



    }

public void checkForWinner(){

    boolean there_is_a_winner=false;

    if(a1.getText()==a2.getText() && a2.getText()==a3.getText()&& !a1.isClickable()) {

        there_is_a_winner = true;
    }
        else if(b1.getText()==b2.getText() && b2.getText()==b3.getText() && !b1.isClickable()) {

        there_is_a_winner = true;
    }
        else if(c1.getText()==c2.getText() && c2.getText()==c3.getText() && !c1.isClickable())
    {
        there_is_a_winner=true;
    }



    //vertical
    else if(a1.getText()==b1.getText() && b1.getText()==c1.getText() && !a1.isClickable()) {

        there_is_a_winner = true;
    }
    else if(a2.getText()==b2.getText() && b2.getText()==c2.getText() && !a2.isClickable())
    {
        there_is_a_winner=true;
    } else if(a3.getText()==b3.getText() && b3.getText()==c3.getText() && !a3.isClickable()) {

        there_is_a_winner = true;
    }


    //diagonal
    else if(a1.getText()==b2.getText() && b2.getText()==c3.getText() && !a1.isClickable())
    {
        there_is_a_winner=true;
    } else if(a3.getText()==b2.getText() && b2.getText()==c1.getText() && !b2.isClickable()) {

        there_is_a_winner = true;
    }



    if(there_is_a_winner) {
        if (!turn) {

            Toast.makeText(MainActivity.this, "X wins", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(MainActivity.this, "O Wins", Toast.LENGTH_SHORT).show();
        }
        enabledisable(false);
    }
else if(turn_Count==9){


            Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();

        }



}






}
