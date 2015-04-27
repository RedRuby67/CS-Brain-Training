package com.roninsamakun.csbraintraining;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
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


    private SharedPreferences Answers;
    private SharedPreferences.Editor AnswersEditor;
    private static final int PREFERENCE_MODE_PRIVATE = 0;

    // I made this global, it's techincally not safe code, so we should make some function to access it later -Casey
    // Begin storing question data
    //{ "questionX", "answerA", "answerB", "answerC", "answerD", "1", "category" };

    public static final String[][] QuestionsArray = new String[][] {
            new String[] {"How many times will the word 'hello' appear? \n\n c = 5 \n a = 7 \n b = 8 \n c = b - c \n for i in range(0, c): \n    print('hello')", "5", "7", "8", "3", "4", "python"},
            new String[] { "A ladybug has two methods: move(), which moves her one space in the direction she's facing, and rotate(), which rotates the direction she's facing 90 degrees clockwise. \n If the ladybug is on a board like the one below, what instruction would you need to use to get the ladybug from point A (where she sits looking North) to point B. \n . . . . . \n .A. .X.X. \n .X. . .X. \n .X.X. .B.", "rotate, move, rotate, move, rotate x3, move, rotate, move, rotatex3", "rotatex3, move, rotate, move, rotate x3, move, rotate, move, rotate", " move, rotate, move, rotate, move x3, rotate, move", "rotate, move x2, rotate, move, rotate, move", "1", "python" },
            new String[] { "You have a program like the one below. What would be returned if you call F(3)? \n def F(n): \n     if n == 0: return 0 \n     elif n == 1: return 1 \n     else: return F(n-1)+F(n-2)", "2", "1", "3", "5", "1", "python" },
            new String[] { "Which of these is used as an escape character in strings?", "Forward slash (/)", "Backslash (\\)", "Single Quote (')", "Double Quote ('')", "2", "general"},
            new String[] { "What will c be equal to at the end of this program? \n a = 3 \n b = 2 \n c = a + b \n b = 4 \n a = a + b \n c = c + a", "12", "5", "10", "7", "1", "python" },
            new String[] { "What will c be equal to at the end of this program? \n a = 4 \n b = 5 \n c = a \n d = c \n if (a + 2 > b + 1): \n     c = 2 * c \n else: \n     c = c / 2", "2", "4", "5", "3", "1", "python" },
            new String[] { "What will print? \n a = 'foo' \n b = 'bar' \n c = ' ' \n d = a + b + c + a + b \n print('d')", "d", "foobar foobar", "foobarfoobar", "foobar", "1", "python" },
            new String[] { "What will print? \n a = 'foo' \n b = 'bar' \n c = ' ' \n d = a + b + c + a + b \n print(d)", "d", "foobar foobar", "foobarfoobar", "foobar", "2", "python" },
            new String[] { "What will print? \n\n a = 5 \n b = 5 \n\n if (a - b < 0): \n    print('foo') \n elif (5 == 6): \n     print('baf') \n elif (7 == 8): \n     print('bof') \n else: \n     print('bar')", "foo", "bar", "baf", "bof", "2", "python" },
            new String[] { "What will the following code print? \n\n mystring = 'Hello' \n mystring += ' world.' \n print mystring", "Hello World", "Helloworld", "Hello", " world", "1", "python" },
            new String[] { "A makefile has:", "a target", "dependencies", "commands", "all the above", "4", "unix" },
            new String[] { "In C++, lines are terminated with a", "colon (:)", "semicolon (;)", "period (.)", "forward-slash (/)", "2", "cpp" },
            new String[] { "What is the correct HTML tag for a line break?", "<lb>", "<bl>", "<br>", "<break>", "3", "html" },
            new String[] { "How many times will 'hello' print from the following code?\n\tfor(i=2; i<=4; i++)\n\t\tprint 'hello';", "3", "2", "4", "None of the above", "1", "c" }
    };

    public static int totalQuestions = 14;

    public static final String[] categoryArray = {"python","html","c","cpp","unix","general"};

    private int[] score = {0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_game);

        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        // Set up the shared preferences editor
        Answers = this.getSharedPreferences("ANSWERS",PREFERENCE_MODE_PRIVATE);
        AnswersEditor = Answers.edit();

        questionSetup();

    }

    public void questionSetup(){

        TextView problem = (TextView) findViewById(R.id.questionText);
        problem.setMovementMethod(new ScrollingMovementMethod());
        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);

//        int totalQuestions = QuestionsArray.length;
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


        answerA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(QuestionsArray[questionNumber][5].equals("1")) {
                    correct.show();
                    incrementScore(true);
                    AnswersEditor.putBoolean(String.valueOf(questionNumber), true);
                    AnswersEditor.commit();
                    questionSetup();
                }
                else {
                    incrementScore(false);
                    incorrect.show();
                }
            }
        });
        answerB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("2")) {
                    correct.show();
                    incrementScore(true);
                    AnswersEditor.putBoolean(String.valueOf(questionNumber), true);
                    AnswersEditor.commit();
                    questionSetup();
                }
                else {
                    incrementScore(false);
                    incorrect.show();
                }
            }
        });
        answerC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("3")) {
                    correct.show();
                    incrementScore(true);
                    AnswersEditor.putBoolean(String.valueOf(questionNumber), true);
                    AnswersEditor.commit();
                    questionSetup();
                }
                else {
                    incrementScore(false);
                    incorrect.show();
                }
            }
        });
        answerD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(QuestionsArray[questionNumber][5].equals("4")) {
                    correct.show();
                    incrementScore(true);
                    AnswersEditor.putBoolean(String.valueOf(questionNumber), true);
                    AnswersEditor.commit();
                    questionSetup();
                }
                else {
                    incrementScore(false);
                    incorrect.show();
                }
            }
        });

    }

    public int[] getScore() {
        return score;
    }

    private void incrementScore(boolean isRight) {
        if (isRight == true) {
            score[0] = score[0] + 1;
        }
        score[1] = score[1] + 1;
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
