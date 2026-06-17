<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTP Verification</title>

<style>

/* Reset */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* Background */
body {
  font-family: 'Arial', sans-serif;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #2c3e50, #27ae60, #1abc9c, #16a085);
  background-size: 400% 400%;
  animation: gradientBG 15s ease infinite;
}
@keyframes gradientBG {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}

/* OTP Box */
.box {
  background: rgba(255,255,255,0.15);
  backdrop-filter: blur(12px);
  -webkit-backdrop-filter: blur(12px);
  border-radius: 15px;
  padding: 40px;
  text-align: center;
  color: #fff;
  box-shadow: 0 8px 25px rgba(0,0,0,0.4);
  width: 320px;
  animation: fadeIn 1.2s ease-out;
}
@keyframes fadeIn {
  from { opacity: 0; transform: scale(0.9); }
  to { opacity: 1; transform: scale(1); }
}

/* Heading */
.box h2 {
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: 700;
  text-shadow: 0 0 10px rgba(0,0,0,0.5);
}

/* Input */
.box input[type="number"] {
  width: 100%;
  padding: 12px;
  border-radius: 8px;
  border: none;
  outline: none;
  font-size: 16px;
  margin-top: 10px;
  margin-bottom: 20px;
  text-align: center;
  background: rgba(255,255,255,0.2);
  color: #fff;
  box-shadow: inset 0 0 8px rgba(0,0,0,0.3);
}
.box input[type="number"]::placeholder {
  color: #ddd;
}

/* Button */
.box button {
  width: 100%;
  padding: 12px;
  border-radius: 8px;
  border: none;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  background: linear-gradient(135deg, #00c853, #69f0ae);
  color: #fff;
  transition: all 0.3s ease;
  box-shadow: 0 6px 15px rgba(0,200,83,0.5);
}
.box button:hover {
  transform: scale(1.05);
  box-shadow: 0 8px 20px rgba(0,200,83,0.7);
}

</style>

</head>
<body>

<div class="box">

<h2>Enter OTP</h2>

<form action="VerifyOTPServlet"
      method="post">

<input type="number"
       name="otp"
       required>

<br><br>

<button type="submit">
Verify OTP
</button>

</form>

</div>

</body>
</html>