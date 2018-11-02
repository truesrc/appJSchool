<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="JSchool">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AZOFT</title>
    <link href="/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script src="/js/angular.js"></script>
    <script src="/js/sortingTable.js"></script>
    <link rel="stylesheet" href="/css/bootstrap/bootstrap.css">

</head>
<body>
<p class=logo><a href="http://www.azoft.ru"><img src="/image/logo.png" alt="logo"></a></p>
<div align="center">
    <h1>База юзеров:</h1>
    <table class="sort" border="1" ng-controller="getAllUsers">
        <thead>
        <tr>
            <td class=edit_delete>Edit</td>
            <td id=id>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Login</td>
            <td>Password</td>
            <td>Country</td>
            <td>City</td>
            <td>Street</td>
            <td>House</td>
            <td>AboutMe</td>
            <td>DateOfBirth</td>
            <td class=edit_delete>Del</td>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="user in allUsers | orderBy: 'id'">
            <td> <a href="/users/{{user.id}}" class="btn btn-warning btn-xs">Edit</a> </td>
            <td>{{user.id}}</td>
            <td>{{user.name}}</td>
            <td>{{user.surname}}</td>
            <td>{{user.login}}</td>
            <td>{{user.password}}</td>
            <td>{{user.address.country}}</td>
            <td>{{user.address.city}}</td>
            <td>{{user.address.street}}</td>
            <td>{{user.address.house}}</td>
            <td>{{user.aboutMe}}</td>
            <td>{{user.dateOfBirth | date : "dd.MM.y" }}</td>
            <td> <a href="/users" ng-click="delete(user)" class="btn btn-danger btn-xs">Delete</a> </td>
        </tr>
        </tbody>
    </table>
    <br> <a href="/" class="btn btn-primary">Home</a>
</div>
</body>
</html>

