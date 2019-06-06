<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: hathu
  Date: 2019-05-28
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- card ui -->
<%Student student = (Student) request.getAttribute("student");
if(student == null){
    student = new Student();
}
%>
<div class="con">
    <div class="card">
        <div class="about">
            <h1>Sign up</h1>
            <!--       <h2>oDsoky .<span>inc</span></h2> -->
            <p>Join Our Community</p>
        </div>
        <form autocomplete="off" method="post" action="/member/register">

            <div class="inputs">
                <!--         <i class="fa fa-envelope-o" aria-hidden="true"></i> -->
                <input name="userName" type="text" placeholder="UserName" required value="<%=student.getUsername()%>"/>
                <input name="fullName" type="text" placeholder="Full Name" value="<%=student.getFullname()%>"/>

                <input name="address" type="text" placeholder="Address" required value="<%=student.getAddress()%>"/>
                <input name="email" type="text" placeholder="Email" required value="<%=student.getEmail()%>"/>

                <input name="password" type="password" placeholder="Password" required/>
                <input name="cofPassword" type="password" placeholder="Confirm Password" required/>
                <select name="role" >
                    <option value="member">Member</option>
                    <option value="admin">Admin</option>
                </select>
            <!--       terms -->
            <div class="terms">
                <input type="checkbox" id="signing" name="signing">
                <label for="signing"><p>i agree with <i>terms and conditions</i></p></label>
            </div>
            <button class="submit">SIGN UP</button>

            <div class="login">
                <!--       Already a member -->
                <label id="login" for="login"><p> Already a member! <a href="/member/login"><span> Login </span></a></p></label>
            </div>
        </form>
    </div></div>
</body>
</html>
<style>
    /* Fonts */
    @import url('https://fonts.googleapis.com/css?family=Amaranth|Changa+One|Comfortaa|Concert+One|Merriweather|Rozha+One');
    /* End Fonts */
    *{transition: all .3s linear; box-sizing: border-box;}
    body{
        /*   background-color: #fbc2eb; */


        background-image: linear-gradient( 135deg, #fbc2eb 10%, #FF52E5 100%);
        background-repeat: no-repeat;
        background-attachment: fixed;
        font-family: 'Comfortaa', cursive;

    }

    .card {
        width: 700px;
        height: 400px;
        background: rgba(255, 255, 255, 0.56);
        margin: 10px auto 0;
        box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
        /*   background-image: linear-gradient(60deg, #64b3f4 0%, #c2e59c 100%); */
        /*   background-image: linear-gradient(to top, #bdc2e8 0%, #bdc2e8 1%, #e6dee9 100%); */
        background: rgba(0,0,0,0.07) 73%);
        /*   padding: 50px; */
        text-align: center;
        border-radius: 5px;
        position: relative;
        margin-top: 5%;
    }
    .about{
        width: 40%;
        height: 100%;
        float: left;
        background: url(https://s-media-cache-ak0.pinimg.com/736x/f7/cf/e1/f7cfe19050679efd4fa855ab99461ac4.jpg);
        background-size: cover;
        color: #649DAD;
        /*   box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); */
    }
    /* about p*/
    .about h1, p {margin-top: 40px;}
    /* form */
    form {
        margin-top: 20px;
        width: 60%;
        height: 100%;
        float: right;
        overflow: hidden;
    }
    /* input[type=text] */
    form .inputs input {
        width: 45%;
        padding: 12px 20px;
        margin: 10px 0;
        font-family: 'Comfortaa', cursive;
        border: none;
        outline: none;
        background: rgba(0,0,0,0.140);
        border-radius: 5px;

    }
    input[type]:focus {
        background: rgba(0,0,0,0.40);
        color: #FFF;
    }


    .submit {
        background: transparent;
        border: 2px solid #DEC8F6;
        width: 50%;
        padding: 12px 20px;
        margin: 8px 0;
        font-family: 'Comfortaa', cursive;
        outline: none;
        border-radius: 5px;

        cursor: pointer;
        margin-top: 10px;
        transition: all 0.3s;

        position: relative;
    }
    .submit::before{
        content: '';
        position: absolute;
        width: 100%;
        height:0;
        background: rgba(0,0,0,0.32);
        top:0;
        left:0;
        z-index:-1;
        transition: all 0.3s;
        content: '';
        position: absolute;
    }
    .submit:hover:before{
        height:100%;
    }
    /* terms */

    /* p  */
    .terms p{
        font-size: 80%;
        display: inline-block;
    }
    .terms i {
        text-decoration: underline;
        color:#771B66;
        cursor: pointer;
    }
    .terms i:hover{color:#96F;}


    /* .login */
    .login {margin-top: 30px;}
    #login p {
        font-size: 80%;
    }

    #login span{
        font-weight: bolder;
        text-decoration: underline;
        color:#771B66;
        cursor: pointer;
    }
    #login span:hover{color:#96F;}
</style>