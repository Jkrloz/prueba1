package com.example.susanadominguez.prueba1;

import android.app.Activity;
import android.app.AlertDialog;


import android.content.DialogInterface;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;


import android.content.DialogInterface;

public class Game extends Activity {

    int scoreP1 = 20; //score que se muestra en pantalla
    int scoreP2 = 20;
    TextView tvp1;
    TextView tvp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    public  void reset(View v){
        scoreP2=20;
        scoreP1=20;
        updateScreen();

    }

    public void updateScreen(){
        tvp1 = (TextView) findViewById(R.id.player1);
        tvp1.setText(Integer.toString(scoreP1));
        tvp2 = (TextView) findViewById(R.id.player2);
        tvp2.setText(Integer.toString(scoreP2));

    }



    public void updateLife (View v) {

        switch (v.getId()){
            case R.id.buttonPlus1P1:
                scoreP1++;
                break;

            case R.id.buttonPlus5P1:
                scoreP1+=5;
                break;

            case R.id.buttonMinus1P1:
                scoreP1--;
                break;

            case R.id.buttonMinus5P1:
                scoreP1-=5;
                break;

            case R.id.buttonPlus1P2:
                scoreP2++;
                break;

            case R.id.buttonPlus5P2:
                scoreP2+=5;
                break;

            case R.id.buttonMinus1P2:
                scoreP2--;
                break;

            case R.id.buttonMinus5P2:
                scoreP2-=5;
                break;

        }


        updateScreen();


    }


    public void win(final View v) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:

                        //SharedPreferences sp = getPreferences(MODE_PRIVATE);

                        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor sp1 = sp.edit();
                        int i;

                        switch (v.getId()){
                            case R.id.p1w:
                                i = sp.getInt("score_P1",0);
                                i+=1;
                                sp1.putInt("score_P1", i);
                                sp1.commit();
                                break;

                            case R.id.p2w:
                                i = sp.getInt("score_P2",0);
                                i+=1;
                                sp1.putInt("score_P2", i);
                                sp1.commit();
                                break;
                        }

                        reset(v);
                        updateScreen();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Estás Seguro?").setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();





    }







}
