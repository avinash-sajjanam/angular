var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider){
	$routeProvider
	.when("/books",{
		templateUrl:"resources/partials/book-list.html",
		controller:"BookListCtrl"
	})
	.when("/kart",{
		templateUrl:"resources/partials/kart-list.html",
			controller:"KartListCtrl"
	})
	.otherwise({
		redirectTo:"/books"
	})
});
myApp.factory("kartService",function(){
	var kart=[];
	return{
		getKart: function(book){
			return kart;
		},
		addToKart:function(book){
			kart.push(book);
		},
		buy: function(book){
			alert("thanks for buying: ",book.name);
		}
	}
});
myApp.factory("bookService", function(){
	var books=[
	           {
	        	   imgUrl:"adultery.jpeg",
	            	  name:"Adultery",
	            	  price:205,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"abc"
	              },
	              {
	            	  imgUrl:"geronimo.jpeg",
	            	  name:"Geronimo Stilton Spacemice#2 : You're Mine, Captain!",
	            	  price:255,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"def"
	              },
	              {
	            	  imgUrl:"life-or-death.jpeg",
	            	  name:"Life or Death",
	            	  price:288,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"ghi"
	              },
	              {
	            	  imgUrl:"playing.jpeg",
	            	  name:"Playing It My Way : My Autobiography",
	            	  price:355,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"jkl"
	              },
	              {
	            	  imgUrl:"the-fault.jpeg",
	            	  name:"The Fault in Our Stars",
	            	  price:215,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"mno"
	              },
	              {
	            	  imgUrl:"wings-of-fire.jpeg",
	            	  name:"Wings of Fire: An Autobiography",
	            	  price:855,
	            	  rating:4,
	            	  binding:"paperback",
	            	  publisher:"Random",
	            	  releaseDate:"10-02-2014",
	            	  details:"pqr" 
	           }];
	return{
		getBooks:function(){
			return books;
		},
		addToKart: function(book){
			
		}
	}
});
myApp.controller("KartListCtrl",function($scope, kartService){
	$scope.kart=kartService.getKart();
	$scope.buy=function(book){
		kartService.buy(book);
	}
});
myApp.controller("HeaderCtrl",function($scope){
	$scope.appDetails={};
	$scope.appDetails.title="Book Kart";
	$scope.appDetails.tagline="We have collection of 1 Million books";
});
myApp.controller("BookListCtrl", function($scope,bookService,kartService){
	$scope.books=bookService.getBooks();
	$scope.addToKart=function(book){
		kartService.addToKart(book);
	}
	
});