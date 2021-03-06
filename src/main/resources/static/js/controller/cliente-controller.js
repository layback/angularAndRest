appCliente.controller("clienteController", function($scope, $http) {
	
	$scope.nome = "";
	$scope.clientes = [];
	$scope.cliente = {};
	
	$scope.carregarClientes = function() {
		$http({method:'GET', url:'/clientes'}).then(
			function(response){
				$scope.clientes = response.data;
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			}
		);
	}
	
	$scope.salvarCliente = function () {
		$http({method:'POST', url:'/clientes', data: $scope.cliente}).then(
			function(response){
				$scope.carregarClientes();
				$scope.cancelar();
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			}
		);
	}
	
	$scope.removerCliente = function (cliente) {
		$http({method:'DELETE', url:'/clientes/'+ cliente.id}).then(
				function(response){
					pos = $scope.clientes.indexOf(cliente);
					$scope.clientes.splice(pos, 1);
				}, 
				function(response){
					console.log(response.data);
					console.log(response.status);
				}
		);
	}
	
	$scope.alterarCliente = function (cliente) {
		$scope.cliente = angular.copy(cliente);
	}
	
	$scope.cancelar = function () {
		$scope.cliente = {};
	}
	
	$scope.carregarClientes();
	
});