appCliente.controller("veiculoController", function($scope, $http) {
	$scope.veiculos = [];
	$scope.veiculo = {};
	
	$scope.carregarVeiculos = function() {
		$http({method:'GET', url:'/veiculos'}).then(
			function(response){
				$scope.veiculos = response.data;
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			}
		);
	}
	
	$scope.salvarVeiculo = function () {
		$http({method:'POST', url:'/veiculos', data: $scope.veiculo}).then(
			function(response){
				$scope.carregarVeiculos();
				$scope.cancelar();
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			}
		);
	}
	
	$scope.cancelar = function () {
		$scope.veiculo = {};
	}
	
	$scope.carregarVeiculos();
});