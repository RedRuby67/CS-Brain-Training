package com.roninsamakun.csbraintraining;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ReviewGames extends ActionBarActivity {

    private SharedPreferences Answers;
    private static final int PREFERENCE_MODE_PRIVATE = 0;
    ListView mainListView;
    ArrayAdapter ArrayAdapter;
    ArrayList AnswerList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_games);

        // See saved preferences.
        Answers = this.getSharedPreferences("ANSWERS",PREFERENCE_MODE_PRIVATE);

        // Access the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);

        // Create an ArrayAdapter for the ListView
        ArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                AnswerList);

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(ArrayAdapter);

        // Populate the ListView with data from our questions.
        for (int i = 0; i < 15; i++) {
            if (Answers.getBoolean(String.valueOf(i),false)) {
                AnswerList.add("Question " + String.valueOf(i) + " was answered correctly.");
                ArrayAdapter.notifyDataSetChanged();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review_games, menu);
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
}
