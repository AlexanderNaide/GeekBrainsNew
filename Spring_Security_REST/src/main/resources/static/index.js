angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/api/v1/products';
    let number = 1;
    let totalNumber;

    $scope.updateProducts = function () {
        let min;
        let max;
        let bF;
        let cat;
        let sub_cat;
        let man;
        if ($scope.filter !== null){
            bF = true;
            min = $scope.filter.min !== null ? $scope.filter.min : null;
            max = $scope.filter.max !== null ? $scope.filter.max : null;
            cat = $scope.filter.cat !== "Все" ? $scope.filter.cat : null;
            sub_cat = $scope.filter.sub_cat !== "Все" ? $scope.filter.sub_cat : null;
            man = $scope.filter.man !== "Все" ? $scope.filter.man : null;
        }
        $http({
            url: contextPath,
            method: 'POST',
            params: {
                val: $scope.value !== null ? $scope.value : null,
                min: bF ? min : null,
                max: bF ? max : null,
                cat: cat,
                sub_cat: sub_cat,
                man: man,
                page: number
            }
        }).then(function (response) {
            $scope.pagination(response);
            $scope.ProductsList = response.data.content;
            // console.log(response.data)
            });
    };

    $scope.loadProducts = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
            $scope.pagination(response);
            $scope.ProductsList = response.data.content;
            // console.log(response.data)
        });
    };

    $scope.categories = function () {
        $http({
            url: contextPath + "/categories",
            method: 'GET'
        }).then(function (response) {
            $scope.CategoriesList = response.data;
        });
    };

    $scope.getProduct = function (id) {
        $http({
            url: contextPath + "/" + id,
            method: 'GET'
        }).then(function (response) {
            // console.log(response);
            $scope.Product = response.data;
            let descStr = response.data.description;
            let st = descStr.indexOf("<");
            if(st === -1){
                $scope.ProductDescription = descStr.split("; ");
            } else {
                let desc = descStr.slice(0, st);
                $scope.ProductDescription = desc.split("; ");
            }
        });
    };

    $scope.manufacturer = function () {
        let cat;
        let sub_cat;
        if ($scope.filter !== null){
            cat = $scope.filter.cat !== "Все" ? $scope.filter.cat : null;
            sub_cat = $scope.filter.sub_cat !== "Все" ? $scope.filter.sub_cat : null;
        }
        $http({
            url: contextPath + "/man",
            method: 'GET',
            params: {
                cat: cat,
                sub_cat: sub_cat
            }
        }).then(function (response) {
            $scope.ManufacturerList = response.data;
        });
    };

    $scope.showCart = function () {
        $http({
            url: contextPath + "/cart",
            method: 'GET'
        }).then(function (response) {
            $scope.CardList = response.data;
            $scope.CardTotalSize = $scope.CardList.length;
            let total = 0;
            let summ = 0;
            for (let p of $scope.CardList) {
                let count = p.count;
                let price = p.price;
                total += count;
                summ += (count * price);
            }
            $scope.CardTotalProduct = total;
            $scope.CardTotalSumm = summ;
        });
    };

    $scope.addToCart = function (id, count) {
        $http({
            url: contextPath + "/add_to_cart",
            method: 'POST',
            params: {
                id: id,
                count: count
            }
        }).then(function (response) {
            $scope.showCart();
        });
    };

    $scope.deleteProductFromCart = function (id) {
        $http({
            url: contextPath + "/dell_from_cart",
            method: 'POST',
            params: {
                id: id
            }
        }).then(function (response) {
            $scope.showCart();
        });
    };

    $scope.searchForm = function () {
        number = 1;
        $scope.updateProducts();
        $scope.manufacturer();
    };

    $scope.catForm = function () {
        if($scope.filter !== null && $scope.filter.cat !== null){
            $('#sub').prop('disabled', false);
            $http({
                url: contextPath + "/sub_categories",
                method: 'GET',
                params: {
                    cat: $scope.filter.cat
                }
            }).then(function (response) {
                if(response.data.length === 1){
                    $scope.SubCategoriesList = null;
                    $('#sub').prop( 'disabled',true );
                } else {
                    $scope.SubCategoriesList = response.data;
                }
            });
        } else {
            $scope.SubCategoriesList = null;
            $('#sub').prop( 'disabled',true );
        }
    };

    $scope.addFilter = function () {
        number = 1;
        $scope.updateProducts();
    };

    $scope.resetFilter = function () {
        $scope.filter = null;
        $scope.categories();
        $scope.catForm();
        $scope.manufacturer();
        $scope.updateProducts();
    };

    $scope.pagination = function (response) {
        totalNumber = response.data.totalPages;
        $scope.totalNumber = response.data.totalPages;
        $scope.first = response.data.first === true ? 'disabled' : null;
        $scope.first10 = response.data.number < 10 ? 'disabled' : null;
        $scope.page1 = response.data.number + 1;
        $scope.last10 = response.data.number > totalNumber - 11 ? 'disabled' : null;
        $scope.last = response.data.last === true ? 'disabled' : null;
    };

    $scope.pageClick = function (delta) {
        number = number + delta;
        $scope.updateProducts();
    };

    $scope.pageStart = function () {
        number = 1;
        $scope.updateProducts();
    };

    $scope.pageFinish = function () {
        number = totalNumber;
        $scope.updateProducts();
    };

    $scope.filter = null;
    $scope.loadProducts();
    $scope.categories();
    $scope.manufacturer();
    $scope.showCart();
    $('#sub').prop( 'disabled',true );

});