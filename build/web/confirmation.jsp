<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Survey Confirmation</title>
    <link rel="stylesheet" href="style/main.css">
</head>
<body>
    <div class="survey_frame">
        <h1>Thanks for filling out the survey</h1>

        <div class="confirmation-box">
            <p><b>First Name:</b> ${firstName}</p>
            <p><b>Last Name:</b> ${lastName}</p>
            <p><b>Email:</b> ${email}</p>
            <p><b>Date of Birth:</b> ${dateOfBirth}</p>
            <p><b>Heard From:</b> ${heard}</p>
            <p><b>Wants Updates:</b> ${announcement}</p>
            <p><b>Email OK:</b> ${emailAnnouncement}</p>
            <p><b>Contact Via:</b> ${contactVia}</p>
        </div>

        <hr>

        <form action="emailList" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" class="submit-btn">
        </form>
    </div>
</body>
</html>
