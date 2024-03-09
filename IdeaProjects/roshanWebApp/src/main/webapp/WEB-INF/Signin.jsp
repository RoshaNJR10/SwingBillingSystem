<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Sign In</title>
    <script>
        function validateForm() {
            const name = document.forms["signInForm"]["name"].value;
            const address = document.forms["signInForm"]["address"].value;
            const age = document.forms["signInForm"]["age"].value;
            const gender = document.forms["signInForm"]["gender"].value;
            const faculty = document.forms["signInForm"]["faculty"].value;
            const email = document.forms["signInForm"]["email"].value;
            const contact = document.forms["signInForm"]["contact"].value;

            if (name === "" || address === "" || age === "" || gender === "" || faculty === "" || email === "" || contact === "" ) {
                alert("All fields must be filled out");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center font-italic">Sign In Form</h1>
                </div>
                <div class="card-body">
                    <form action="save" method="post" name="signInForm" onsubmit="return validateForm()">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" name="name" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" name="address" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="age">Age:</label>
                            <input type="text" name="age" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="gender">Gender:</label>
                            <select name="gender" class="form-control">
                                <option value="">Select Gender</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="faculty">Faculty:</label>
                            <select name="faculty" class="form-control">
                                <option value="">Select Faculty</option>
                                <option value="Bsc.Csit">Bsc.CSIT</option>
                                <option value="BIM">BIM</option>
                                <option value="BCA">BCA</option>
                                <option value="BIT">BIT</option>
                                <option value="BBS">BBS</option>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" name="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="contact">Contact:</label>
                            <input type="text" name="contact" class="form-control">
                        </div>

                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-primary btn-block" value="Submit">
                        </div>
                        <p class="text-center">Already have an account? <a href="#">Login</a></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
