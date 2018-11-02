<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html ng-app="JSchool">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AZOFT</title>
    <link href="/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script src="/js/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
</head>

<body>
<p class=logo><a href="http://www.azoft.ru/"><img src="/image/logo.png" alt="logo"></a></p>
<div align=center>
    <h1 ng-init="init=${user.id}">Редактировать юзера:</h1>
    <div ng-controller="getUser">
        <form>
            <table>
                <tr>
                    <td>ID:</td>
                    <td>{{user.id}}</td>
                </tr>
                <tr>
                    <td>Имя:</td>
                    <td><input ng-model="user.name"/></td>
                </tr>
                <tr>
                    <td>Фамилия:</td>
                    <td><input ng-model="user.surname"/></td>
                </tr>
                <tr>
                    <td>Логин:</td>
                    <td><input ng-model="user.login"/></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input ng-model="user.password"/></td>
                </tr>

                <tr>
                    <td>Страна:</td>
                    <td><input ng-model="user.address.country"/></td>
                </tr>
                <tr>
                    <td>Город:</td>
                    <td><input ng-model="user.address.city"/></td>
                </tr>
                <tr>
                    <td>Улица:</td>
                    <td><input ng-model="user.address.street"/></td>
                </tr>
                <tr>
                    <td>Дом:</td>
                    <td><input ng-model="user.address.house"/></td>
                </tr>

                <tr>
                    <td>Дата рождения:</td>
                    <td><input type=date ng-model="user.dateOfBirth"/></td>
                </tr>
                <tr>
                    <td>О себе</td>
                    <td><textarea rows=5 cols=30 ng-model="user.aboutMe">{{user.aboutMe}}</textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href=/ ng-click="edit()" class="btn btn-success">Отправить</a></td>
                </tr>
            </table>
        </form>
    </div>
    <br>
    <a href=/ class="btn btn-primary">Home</a>
</div>
</body>
</html>