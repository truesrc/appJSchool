var myApp = angular.module('JSchool', []);

myApp.controller('getAllUsers', function ($scope, $http) {
    $scope.allUsers = [];

    $http.get('http://localhost:8080/users?').then(function (response) {
        $scope.allUsers = response.data;
    });

    $scope.delete = function (user) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/users/' + user.id,
            dataType: 'json'
        });
    };
});


myApp.controller('getUser', function ($scope, $http) {
    $scope.user = {};

    $http.get('http://localhost:8080/users/' + $scope.init).then(function (response) {
        $scope.user = response.data;
    });

    $scope.edit = function () {
        $http({
            method: 'PUT',
            url: 'http://localhost:8080/users/' + $scope.user.id,
            dataType: 'json',
            data: JSON.stringify($scope.user)
        });
    };
});


myApp.controller('postUser', function ($scope, $http) {
    $scope.user = {};

    $scope.post = function (form) {
        if (form.$valid) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/users/',
                dataType: 'json',
                data: JSON.stringify($scope.user)
            });
        }
    };
});


/**
 * Here we have Angular app.
 * In the controller getAllUsers app request to server and automatically fills in a table cell on users.jsp
 *
 *In the controller getUser app fills in a table cell on edit.jsp
 *
 *In controllers two functions are defined: edit and delete.
 * Edit sends data about user using the PUT method.
 *Delete func  remove user by id using DELETE method.
 *
 *
 *
 *
 */





























