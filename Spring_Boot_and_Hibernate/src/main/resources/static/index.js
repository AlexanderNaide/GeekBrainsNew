angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/products';
    let min = 0;
    let max = -1;
    let val = '';

    $scope.updateProducts = function () {
        $http({
            url: contextPath,
            method: 'POST',
            params: {
                val: val,
                min: min,
                max: max
            }
        }).then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.loadProducts = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.searchForm = function () {
        val = $scope.value;
        $scope.updateProducts();
    };

    $scope.addFilter = function () {
        min = $scope.filter.min !== null ? $scope.filter.min : 0;
        max = $scope.filter.max !== null ? $scope.filter.max : -1;
        $scope.updateProducts();
    };

    $scope.resetFilter = function () {
        $scope.filter = null;
        min = 0;
        max = -1;
        $scope.updateProducts();
    };

    $scope.addProduct = function () {
        $http.post(contextPath + '/add', $scope.newProduct)
            .then(function (response) {
                $scope.updateProducts();
                $scope.newProduct = null;
            });
    };

    $scope.deleteProduct = function (ProductID) {
        $http({
            url: contextPath + '/delete',
            method: 'DELETE',
            params: {
                id: ProductID
            }
        }).then(function (response){
            $scope.updateProducts();
        });
    };

    $scope.loadProducts();
});