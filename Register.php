<?php
    $con=mysqli_connect("mysql8.000webhost.com","a9727808_redruby","password1","a9727808_logreg");

    $user_name = $_POST["user_name"];
    $email = $_POST["email"];
    $password = $_POST["password"];
    $age = $_POST["age"];

    $statement = mysqli_prepare($con, "INSERT INTO User (user_name, email, password, age) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssi", $user_name, $email, $password, $age);
    mysqli_stmt_execute($statement);

    mysqli_stmt_close($statement);

    mysqli_close($con);
?>