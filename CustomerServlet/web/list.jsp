<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <style>
            body
            {
                margin:  50px;
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <form action="custservlet" method="get" id="myForm">
        <input type="hidden" name="action" value="search"/>
        <input type="hidden" name="custId" value="0" id="custFieldId"/>

        <div class="container">
            <h2>This call the customer rest webservices that could be found <a href="http://localhost:8080/CUST_REST/webresources/ws.customer/" target="_blank">here</a></h2>           
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Balance</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td><c:out value="${customer.name}" /></td>
                            <td><c:out value="${customer.country}" /></td>
                            <td><c:out value="${customer.balance}" /></td>
                            <td>
                                <a href="javascript:submitform(${customer.id})">Show</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <span>Styled by boostrap <a href="https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_table_hover&stacked=h" target="_blank">here</a></span>
        </div>
    </form>
    <script>
        function submitform(customerId)
        {
            var field = document.getElementById('custFieldId');
            field.value = customerId;
            document.getElementById("myForm").submit();
        }
    </script>
    </body>
</html>