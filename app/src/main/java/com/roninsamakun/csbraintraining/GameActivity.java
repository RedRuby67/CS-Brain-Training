package com.roninsamakun.csbraintraining;


import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

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

        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);

        // TODO: Remove these comments and actually implement a right/wrong system

        answerA.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Do something to indicate correct or incorrectness
            }
        });
        answerB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Do something to indicate correct or incorrectness
            }
        });
        answerC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Do something to indicate correct or incorrectness
            }
        });
        answerD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Do something to indicate correct or incorrectness
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
