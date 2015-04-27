package com.roninsamakun.csbraintraining;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.widget.Button;

// import needed libraries for event handling and gestures
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

public class RegisterActivity extends ActionBarActivity  implements
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener,
        View.OnClickListener {

    private GestureDetectorCompat gestureDetector;

    Button SignUpButton, GoBackButton;
    EditText user_nameText, passwordConfirmText, passwordText;

    LoginDataBaseAdapter loginDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        SignUpButton = (Button) findViewById(R.id.SignUpButton);
        GoBackButton = (Button) findViewById(R.id.GoBackButton);
        user_nameText = (EditText) findViewById(R.id.user_nameText);
        passwordConfirmText = (EditText) findViewById(R.id.passwordText);
        passwordText = (EditText) findViewById(R.id.passwordConfirmText);

        SignUpButton.setOnClickListener(this);
        GoBackButton.setOnClickListener(this);

        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.SignUpButton:
                // TODO Auto-generated method stub

                String userName=user_nameText.getText().toString();
                String password=passwordText.getText().toString();
                String confirmPassword=passwordConfirmText.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
                break;

            case R.id.GoBackButton:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;

        }
    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
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


}
