<?php
    $con=mysqli_connect("mysql8.000webhost.com","a9727808_redruby","password1","a9727808_logreg");

    $user_name = $_POST["user_name"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "SELECT * FROM User WHERE user_name = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $user_name, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $user_id, $user_name, $email, $password, $age);

    $user = array();

    while(mysqli_stmt_fetch($statement)){
        $user[user_name] = $user_name;
        $user[email] = $email;
        $user[password] = $password;
        $user[age] = $age;
    }

    echo json_encode($user);

    mysqli_stmt_close($statement);

    mysqli_close($con);
?>