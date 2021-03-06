<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Online Library</title>

    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../resources/css/simple-sidebar.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>

<body>

<div id="wrapper">

    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Library
                </a>
            </li>
            <c:if test="${empty pageContext.request.userPrincipal}">
                <li>
                    <a href="/registration">Sign Up</a>
                </li>

                <li>
                    <a href="/login">Sign In</a>
                </li>
            </c:if>
            <li>
                <a href="#">Search</a>
            </li>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
                    <li>
                        <a href="#">My profile</a>
                    </li>
                </c:if>

                <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                    <li>
                        <a href="#">Add book</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </div>

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Online Library</h1>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="../../resources/js/jquery.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>

</body>
</html>
