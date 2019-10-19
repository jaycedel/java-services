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
<a href='javascript:locate("${customer.country}")'>Show Country</a>

<div id="map"></div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeKasUTllOsPhnIT1vik2Wn5FO8N3vCm8&callback=initMap" async defer></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>    
<script>
    var map;
   

    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
    }
    
    function locate(countryCode){
        console.log(countryCode);
         $.ajax({
             
            url: 'http://localhost:8080/COUNTRY_REST/webresources/ws.countries/' + countryCode,
            contentType: "application/xml",
            dataType: 'xml',
            success: function (result) {
                console.log(result);
                
                 xmlDoc = $.parseXML( result );
                 $xml = $( xmlDoc);
                 latitude = $xml.find( "latitude" );
                 longtitude = $xml.find( "longtitude" );
                 console.log(latitude);
                 console.log(longtitude);
                map.setCenter(new google.maps.LatLng(latitude, longtitude));
            }
        })
    }
</script>
</body>