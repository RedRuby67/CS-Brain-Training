package com.roninsamakun.csbraintraining;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

// import needed libraries for event handling and gestures


public class GameActivity extends ActionBarActivity  implements
GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_game);

        // Set up gestures so it no longer crashes
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        TextView problem = (TextView) findViewById(R.id.questionText);
        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);

        // Begin storing question data
        String[] question1 = new String[]
                { "A makefile has:", "a target", "dependencies", "commands", "all the above", "4", "unix" };
        String[] question2 = new String[]
                { "In C++, lines are terminated with a", "colon (:)", "semicolon (;)", "period (.)", "forward-slash (/)", "2", "cpp" };
        String[] question3 = new String[]
                { "What is the correct HTML tag for a line break?", "<lb>", "<bl>", "<br>", "<break>", "3", "html" };
        String[] question4 = new String[]
                { "How many times will 'hello' print from the following code?\n\tfor(i=2; i<=4; i++)\n\t\tprint 'hello';", "3", "2", "4", "None of the above", "1", "c" };
        String[] questionX = new String[]
                { "questionX", "answerA", "answerB", "answerC", "answerD", "1", "category" };

        final String[][] QuestionsArray = new String[][] { question1, question2, question3, question4, questionX };

        int totalQuestions = QuestionsArray.length;
        // Randomly generate a number in [0,totalQuestions) to determine which question loads
        final int questionNumber = new Random().nextInt(totalQuestions);

        // Set text for question and answers
        problem.setText(QuestionsArray[questionNumber][0]);
        answerA.setText(QuestionsArray[questionNumber][1]);
        answerB.setText(QuestionsArray[questionNumber][2]);
        answerC.setText(QuestionsArray[questionNumber][3]);
        answerD.setText(QuestionsArray[questionNumber][4]);

        final Toast correct = Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT);
        correct.setGravity(Gravity.CENTER, 0, 0); // Or, you can set Margin by: toast.setMargin(50,50);

        final Toast incorrect = Toast.makeText(GameActivity.this, "Incorrect", Toast.LENGTH_SHORT);
        incorrect.setGravity(Gravity.CENTER, 0, 0); // Or, you can set Margin by: toast.setMargin(50,50);


        // TODO: Remove these comments and actually implement a right/wrong system

        answerA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(QuestionsArray[questionNumber][5].equals("1")) {
                    correct.show();
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
                else {
                    incorrect.show();
                }
            }
        });
        answerB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("2")) {
                    correct.show();
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
                else {
                    incorrect.show();
                }
            }
        });
        answerC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("3")) {
                    correct.show();
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
                else {
                    incorrect.show();
                }
            }
        });
        answerD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("4")) {
                    correct.show();
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
                else {
                    incorrect.show();
                }
            }
        });

    }

    // methods for gestures

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
