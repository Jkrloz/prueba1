    package com.example.susanadominguez.prueba1;
    import android.app.Activity;
    import android.os.Bundle;
    import android.preference.PreferenceManager;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.content.Intent;
    import android.view.View;
    import android.widget.TextView;
    import android.content.SharedPreferences;

    /**
     * Created by susanadominguez on 14-11-14.
     */

    public class Players extends Activity {

        int score_P1=0;
        int score_P2=0;
        TextView tv1;
        TextView tv2;

        final static String TAG = "Scores";

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_players);

            /*Player1 Susana
            * Player2 Juanki*/
            loadData();

            updateScreen();


        }

        private void updateScreen(){
            TextView tv1 = (TextView) findViewById(R.id.score_P1);
            tv1.setText(Integer.toString(score_P1));

            TextView tv2 = (TextView) findViewById(R.id.score_P2);
            tv2.setText(Integer.toString(score_P2));
        }

        private void loadData(){

            //SharedPreferences sp = getPreferences(MODE_PRIVATE);

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            score_P1 = sp.getInt("score_P1",0);
            score_P2 = sp.getInt("score_P2",0);
            Log.d(TAG, Integer.toString(score_P1));
            Log.d(TAG, Integer.toString(score_P2));

        }

        @Override
         public void onResume() {

            super.onResume();
            loadData();
            updateScreen();

        }

        @Override
        public void onStart() {

            super.onResume();
            loadData();
            updateScreen();

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_home, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
           // if (id == R.id.action_settings) {
           //     return true;
           // }

            return super.onOptionsItemSelected(item);
        }

        public void jugar(View view) {
            Intent i = new Intent(this, Game.class);

            //i.putExtra("direccion", et1.getText().toString()); se pasan los parametros, en nuestro caso los jugadores
            startActivity(i);
        }
    }
