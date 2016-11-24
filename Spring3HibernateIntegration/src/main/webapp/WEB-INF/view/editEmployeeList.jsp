<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 hibernate integration example on www.howtodoinjava.com</title>
</head>
<body>
 
<h2>Employee Management Screen : Spring 3 hibernate integration example on www.howtodoinjava.com</h2>
 
<form:form method="post" action="add" commandName="employee">
 
    <table>
    <tr>
        <td><form:label path="credentials.firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="credentials.firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="credentials.lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="credentials.lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="credentials.email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="credentials.email" /></td>
    </tr>
    <tr>
        <td><form:label path="credentials.telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input path="credentials.telephone" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table> 
</form:form>
 
     
<h3>Employees</h3>
<c:if  test="${!empty employeeList}">
<table class="data">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td>${emp.credentials.lastname}, ${emp.credentials.firstname} </td>
        <td>${emp.credentials.email}</td>
        <td>${emp.credentials.telephone}</td>
        <td><a href="delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>