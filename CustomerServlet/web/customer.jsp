<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        #map {
            height: 350px;
            width: 500px;
        }
        /* Pattern styles */
        .left-half {
            float: left;
            width: 50%;
        }
        .right-half {
            float: left;
            width: 50%;
        }
        .clearfix {
            overflow: auto;
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
        <br>

        <section class="container">
            <div class="left-half">
                <h3>Customer Name: <c:out value="${customer.name}" /></h3>
                <h4>Country: <c:out value="${customer.countryName}"/> (<c:out value="${customer.country}"/>)</h4>
                <h4>Balance: <c:out value="${customer.currencyCode}"/> <c:out value="${customer.balance}"/></h4>
                <div id="map"></div>
            </div>
            <div class="right-half">
              
            </div>
        </section>

        <div style="clearfix"></div>
        <input type="hidden" id="latitude" value="${customer.latitude}"/>
        <input type="hidden" id="longtitude" value="${customer.longtitude}"/>

        <br><br>
        <input type="button" class="btn btn-secondary" value="<- Back to Customer Listings" onclick="history.back()">
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
                    center: {lat: Number(latitude), lng: Number(longtitude)},
                    zoom: 5
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