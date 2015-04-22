package com.roninsamakun.csbraintraining;


import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLLocalDatabase;

    public UserLocalStore(Context context) {
        userLLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor spEditor = userLLocalDatabase.edit();
        spEditor.putString("user_name", user.user_name);
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.putInt("age", user.age);
        spEditor.commit();
    }

    public User getLoggedInUser() {
        if (userLLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String user_name = userLLocalDatabase.getString("user_name", "");
        String email = userLLocalDatabase.getString("email", "");
        String password = userLLocalDatabase.getString("password", "");
        int age = userLLocalDatabase.getInt("age", -1);

        User storedUser = new User(user_name, email, password, age);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn() {
        if (userLLocalDatabase.getBoolean("loggedIn", false) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

}
