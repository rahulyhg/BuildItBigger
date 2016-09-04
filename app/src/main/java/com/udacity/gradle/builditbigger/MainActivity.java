package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.jokeshow.JokeShow;

import gradle.udacity.com.JokeTeller;

public class MainActivity extends ActionBarActivity {

    JokeTeller jokeTeller = new JokeTeller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String joke = jokeTeller.tellJoke();
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, joke));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        String joke = jokeTeller.tellJoke();
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, JokeShow.class);
        i.putExtra("joke",joke);
        startActivity(i);
    }


}