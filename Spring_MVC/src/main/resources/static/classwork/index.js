angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.addStudent = function () {
        $http.post(contextPath + '/addStudent', $scope.newStudent)
            .then(function (response) {
                $scope.loadStudents();
            });
    };

    $scope.deleteStudent = function (StudentID) {
        console.log(StudentID);
        $http.get(contextPath + '/delete/' + StudentID)
            .then(function (response) {
                $scope.loadStudents();
            });
    };

    $scope.loadStudents();
});