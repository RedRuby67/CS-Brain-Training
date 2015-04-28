package com.roninsamakun.csbraintraining.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.roninsamakun.csbraintraining.MainActivity;
import com.roninsamakun.csbraintraining.R;

/**
 * Created by Casey C on 4/2/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    /* Tests go here. To run them, go to the terminal and type "gradlew.bat connectedCheck". */
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testTextViewNotNull() {
        TextView textView = (TextView) activity.findViewById(R.id.textView);
        assertNotNull(textView);
    }
}
