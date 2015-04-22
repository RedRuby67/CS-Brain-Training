package com.roninsamakun.csbraintraining;


public class User {
    String user_name, email, password;
    int age;

    public User (String user_name,String email, String password, int age) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
        this.age = -1;
        this.email = "";
        //this(user_name, "", password, -1);
    }


}
