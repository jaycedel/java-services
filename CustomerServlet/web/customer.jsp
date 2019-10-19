<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        #map {
            height: 350px;
             width: 500px;
        }
    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h4>This call the customer rest webservices that could be found <a href="http://localhost:8080/CUST_REST/webresources/ws.customer/${customer.id}" target="_blank">here</a></h4> 
        <h4>This call the country rest webservices that returns the country latitude and longtitude to load the map could be found <a href="http://localhost:8080/COUNTRY_REST/webresources/ws.countries/${customer.country}" target="_blank">here</a></h4> 
        <h3>Name: <c:out value="${customer.name}" /></h3>
        <h3>Country: <c:out value="${customer.country}" /></h3>
        
        <a href='javascript:locate()' class="btn btn-primary">Show Country</a>
        <input type="button" class="btn btn-secondary" value="Listings" onclick="history.back()">
         
        <input type="hidden" id="latitude" value="${customer.latitude}"/>
        <input type="hidden" id="longtitude" value="${customer.longtitude}"/>
        <div id="map"></div>
        
    </div>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeKasUTllOsPhnIT1vik2Wn5FO8N3vCm8&callback=initMap" async defer></script>
     
    <script>
        var map;
        function initMap() {
            latitude = document.getElementById("latitude").value;
            longtitude = document.getElementById("longtitude").value;
            console.log(latitude);
            console.log(longtitude);
            map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: latitude, lng: longtitude},
                zoom: 8
            });
        }

        function locate() {
            latitude = document.getElementById("latitude").value;
            longtitude = document.getElementById("longtitude").value;
            console.log(latitude);
            console.log(longtitude);
            map.setCenter(new google.maps.LatLng(latitude, longtitude));
        }
    </script>
</body>