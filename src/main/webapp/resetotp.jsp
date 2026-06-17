<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
<link rel="stylesheet" href="resetotp.css">
</head>
<body>

<form action="ResetPasswordServlet" method="post">

    <h2>Reset Password</h2>

    <label for="otp">OTP :</label>
    <input type="text"
           id="otp"
           name="otp"
           placeholder="Enter received OTP"
           required>

    <label for="password">New Password :</label>
    <input type="password"
           id="password"
           name="password"
           placeholder="Min. 8 characters"
           required>

    <label for="confirmPassword">Confirm Password :</label>
    <input type="password"
           id="confirmPassword"
           name="confirmPassword"
           placeholder="Repeat new password"
           required>

    <input type="submit"
           value="Reset Password">

</form>

</body>
</html>
