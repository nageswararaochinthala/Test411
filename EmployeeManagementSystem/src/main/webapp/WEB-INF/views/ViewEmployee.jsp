<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body ng-app="helloApp" ng-controller="HttpController">
Enter Employee Id :<br>
<input type="text" ng-model="id"/>
<input type="submit" value="submit" ng-click="getSubmit()"/>
<table class="table">
    <tr>
        <th>Name
        </th>
        <th>Address
        </th>
        <th>City
        </th>
        <th>Phone
        </th>
     </tr>
     <tr ng-repeat="profile in profiles">
         <td>{{profile.firstname + " " + profile.lastname}}
         </td>
         <td>{{profile.address}}
         </td>
         <td>{{profile.city}}
         </td>
         <td>{{profile.phone}}
         </td>
         </tr>
</table>
 <script>
 var helloApp = angular.module("helloApp", []);
 helloApp.controller("HttpController", [ '$scope', '$http',
 function($scope, $http) {
 $http({method : 'GET',url : '/getAllProfiles'})
 .success(function(data, status, headers, config) {
     $scope.profiles = data;
 })
 .error(function(data, status, headers, config) {
     alert( "failure");
 });
 } ])

          </script>
          </body>
          </html>