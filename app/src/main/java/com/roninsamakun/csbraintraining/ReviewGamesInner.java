package com.roninsamakun.csbraintraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ReviewGamesInner extends ActionBarActivity {

    //TODO: add textviews that include answers as well as the questions.
    TextView question;
    TextView answer;
    int questionId;
    int rightAnswer; //TODO: implement rightAnswer as a method of GameActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_games_inner);

        question = (TextView) findViewById(R.id.Question);
        answer = (TextView) findViewById(R.id.answer);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            questionId = extras.getInt("QuestionName");
            Log.d("in create extras", String.valueOf(questionId));
        }
        Log.d("in create", String.valueOf(questionId));
        question.setText(GameActivity.QuestionsArray[questionId][0]);
        rightAnswer = Integer.parseInt(GameActivity.QuestionsArray[questionId][5]);
        answer.setText("Answer: " + GameActivity.QuestionsArray[questionId][0]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review_games_inner, menu);
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("in resume", String.valueOf(questionId));
        question = (TextView) findViewById(R.id.Question);
        answer = (TextView) findViewById(R.id.answer);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            questionId = extras.getInt("QuestionName");
            Log.d("in resume extras", String.valueOf(questionId));
        }

        question.setText(GameActivity.QuestionsArray[questionId][0]);
        rightAnswer = Integer.parseInt(GameActivity.QuestionsArray[questionId][5]);
        answer.setText("Answer: " + GameActivity.QuestionsArray[questionId][rightAnswer]);

    }
}
