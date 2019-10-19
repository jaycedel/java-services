<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        #map {
            height: 100%;
        }
    </style>
</head>
<body>

    <c:out value="${customer.name}" />
    <c:out value="${customer.country}" />
    <a href='javascript:locate()'>Show Country</a>
    <input type="text" id="latitude" value="${customer.latitude}"/>
    <input type="text" id="longtitude" value="${customer.longtitude}"/>
    <div id="map"></div>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeKasUTllOsPhnIT1vik2Wn5FO8N3vCm8&callback=initMap" async defer></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>    
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