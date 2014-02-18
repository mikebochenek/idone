// Define the REST resource service, allowing us to interact with it as a high level service
angular.module('donesService', ['ngResource']).
    factory('Dones', function($resource){
  return $resource('http://localhost\\:8080/idone/rest/items:itemId', {});
});