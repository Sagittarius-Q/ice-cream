<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>

</head>
<body>

<!-- Sign up form -->
<section class="signup">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">
                <h2 class="form-title">Sign up</h2>
                <%--@elvariable id="userForm" type="com.location.iceCream.model.binding.BindingUserDto"--%>
                <form:form method="POST" class="register-form" id="register-form" action="/user/sign" modelAttribute="userForm">
                    <div class="form-group">
                        <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                        <form:input type="text" name="name" id="name" placeholder="Your Name" path="username"/>
                        <form:errors path="username" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="email"><i class="zmdi zmdi-email"></i></label>
                        <form:input type="email" name="email" id="email" placeholder="Your Email" path="email"/>
                        <form:errors path="email" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                        <form:input type="password" name="pass" id="pass" placeholder="Password" path="password"/>
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                        <form:input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"  path="confirmPassword"/>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                    </div>
                </form:form>
            </div>
            <div class="signup-image">
                <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                <a href="#" class="signup-image-link">I am already member</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>