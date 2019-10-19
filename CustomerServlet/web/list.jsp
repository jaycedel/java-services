<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="custservlet" method="get" id="myForm">
    <input type="hidden" name="action" value="search"/>
    <input type="hidden" name="custId" value="0" id="custFieldId"/>
    <table>
        <tr><td>Name</td><td>Country</td></tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.name}" /></td>
                <td><c:out value="${customer.country}" /></td>
                <td>
                    <a href="javascript:submitform(${customer.id})">Show</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

<script>
    function submitform(customerId)
    {
        var field = document.getElementById('custFieldId');
        field.value = customerId;
        document.getElementById("myForm").submit();
    }
</script>
