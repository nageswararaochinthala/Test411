var app = angular.module('myApp', []);
	app.controller('ValidController', function($scope, $http) {

		var employeeIdLength = 6;
		var json = [111111,222222];
		var jsonLoggedIn = [];
		var jsonLoggedOut = [];

		/* set initial values */
		function defaultValues() {
			$scope.empId = '';
			$scope.invalidMsg = "";
			$scope.showInvalidMsg = false;
			$scope.cssClass = "first";
			$scope.buttonDisable = true;
			$scope.buttonText = "In-Time";
		}

		/* set default values  */
		defaultValues();

		/* function calls to get Employee Ids  */
	/*	getAllEmpIds();
		getLoggedInEmpIds();*/

		/* function to get all employeeIds from jsp as array */
		function getAllEmpIds() {

			var response = $http.post('AllUsers.jsp');
			response.success(function(data, status, headers, config) {
				$scope.jsondata = data;
				json = data;

			});
			response.error(function(data, status, headers, config) {
				alert("failure message: " + JSON.stringify({
					data : data
				}));
			});

		}

		/* function to get loggedIn empIds from jsp as array */
		function getLoggedInEmpIds() {
			var loggedInusers = $http.get('LoggedInUsers.jsp');
			loggedInusers.success(function(data, status, headers, config) {
				jsonLoggedIn = data;
				$scope.loggedInIds = data;

			});
			loggedInusers.error(function(data, status, headers, config) {
				alert("failure message: " + JSON.stringify({
					data : data
				}));
			});

		}

		$scope.validateData = function() {

			$scope.successMessage = "";
			if ($scope.empId.length == employeeIdLength) {
				if (serachInArray($scope.empId, jsonLoggedOut)) {
					$scope.invalidMsg = "you are visited";
					$scope.showInvalidMsg = true;
					$scope.cssClass = "error";
					$scope.buttonDisable = true;
					$scope.buttonText = "invalid";
				} else if (serachInArray($scope.empId, jsonLoggedIn)) {
					$scope.invalidMsg = "";
					$scope.showInvalidMsg = false;
					$scope.cssClass = "ok";
					$scope.buttonDisable = false;
					$scope.buttonText = "Out-Time";

				} else if ($scope.empId.length == employeeIdLength) {
					if (serachInArray($scope.empId, json)) {

						$scope.invalidMsg = "";
						$scope.showInvalidMsg = false;
						$scope.cssClass = "ok";
						$scope.buttonDisable = false;
						$scope.buttonText = "in";

					} else {
						
						$scope.invalidMsg = "Invalid Employee Id";
						$scope.showInvalidMsg = true;
						$scope.cssClass = "error";
						$scope.buttonDisable = true;
						$scope.buttonText = "in";

					}

				}

			} else {
				$scope.cssClass = "error";
				$scope.showInvalidMsg = false;
				$scope.buttonDisable = true;

			}

		};

		/* function for redirect*/
		$scope.redirect = function(empId) {
			if (serachInArray(empId, json)) {
				var flag = true;
				if (serachInArray(empId, jsonLoggedIn)) {
					flag = false;
					var outFlag = true;
					if (serachInArray(empId, jsonLoggedOut))
						outFlag = false;
					if (outFlag) {
						swal({
							title :  empId ,
							text : "Are You Continue To Logout",
							type : "warning",
							showCancelButton : true,
							confirmButtonColor : "#DD6B55",
							confirmButtonText : "Yes",
							cancelButtonText : "No",
							closeOnConfirm : false,
							closeOnCancel : false
						}, function(isConfirm) {
							if (isConfirm) {
								jsonLoggedOut[jsonLoggedOut.length] = empId;
								$scope.jsonLoggedOut = jsonLoggedOut;
								swal("Ok", "Successfully Loggedout", "success");
							} else {
								swal("Try Again", "", "error");
							}
						});
						
					}

				}
				if (flag) {
					swal({
						title :empId ,
						text : "Are You continue to log-In",
						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "Yes",
						cancelButtonText : "No",
						closeOnConfirm : false,
						closeOnCancel : false
					}, function(isConfirm) {
						if (isConfirm) {
							jsonLoggedIn[jsonLoggedIn.length] = empId;
							$scope.loggedInIds = jsonLoggedIn;

							swal("OK", "Success fully Logged-in", "success");
						} else {
							swal("Sorry", "try Again", "error");
						}
					});

				}

			} else {
				alert("invalid employee id" + $scope.empId);
			}
			defaultValues();

			/* window.location.href="second.jsp?empId="+empId; */
		};

		/* function for seraching element in Array */
		function serachInArray(key, arr) {
			var length = arr.length;
			for (var i = 0; i < length; i++) {
				if (key == arr[i])
					return true;
			}
			return false;

		}

		/*  function to click the admin-login button */
		$scope.AdminButton = function() {

			window.location.href = "second.html";

		};

	});

	/* controller to display Date and Time */

	app.controller('timeController', [ '$scope', function($scope) {
		$scope.format = 'd/M/yy h:mm:ss a';
	} ]);

	app.directive("myCurrentTime", function(dateFilter) {
		return function(scope, element, attrs) {
			var format;

			scope.$watch(attrs.myCurrentTime, function(value) {
				format = value;
				updateTime();
			});

			function updateTime() {
				var dt = dateFilter(new Date(), format);
				element.text(dt);
			}

			function updateLater() {
				setTimeout(function() {
					updateTime(); // update DOM
					updateLater(); // schedule another update
				}, 1000);
			}

			updateLater();
		}
	});