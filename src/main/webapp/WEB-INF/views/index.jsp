<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html ng-app="JSchool">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AZOFT</title>
    <link href="/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script src="/js/angular.js"></script>
</head>
<body>
<p class=logo><a href="http://www.azoft.ru/"><img src="/image/logo.png" alt="logo"></a></p>
<div align=center ng-controller="postUser">
    <h1>Добавить юзера:</h1>
    <form name="form" action="/">
        <table >
            <tr>
                <td>Имя:</td>
                <td><input  ng-model="user.name" required /></td>
            </tr>
            <tr>
                <td>Фамилия:</td>
                <td><input ng-model="user.surname" required/></td>
            </tr>
            <tr>
                <td>Логин:</td>
                <td><input ng-model="user.login" required/></td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type=password ng-model="user.password" required/></td>
            </tr>

            <tr>
                <td>Страна:</td>
                <td><input ng-model="user.address.country" required /></td>
            </tr>
            <tr>
                <td>Город:</td>
                <td><input  ng-model="user.address.city" required/></td>
            </tr>
            <tr>
                <td>Улица:</td>
                <td><input ng-model="user.address.street" required/></td>
            </tr>
            <tr>
                <td>Дом:</td>
                <td><input ng-model="user.address.house" required/></td>
            </tr>
            <tr>
                <td>Дата рождения:</td>
                <td><input type=date ng-model="user.dateOfBirth" required></td>
            </tr>
            <tr>
                <td>О себе</td>
                <td><textarea rows="5" cols="30" ng-model="user.aboutMe" required></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit"  ng-click="post(form)" class="btn btn-success" value=Сохранить>
                    </td>

            </tr>
        </table>
    </form>
    <div class="db_users">
        <a href="/users" class="btn btn-info" >Посмотреть базу юзеров</a>
    </div>
</div>
</body>
</html>