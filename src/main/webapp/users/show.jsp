<%--
  Created by IntelliJ IDEA.
  User: kucin
  Date: 31/12/2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../theme/header.jsp"/>

<table class="cinereousTable">
    <thead>
    <tr>
        <th>Typ wartości</th>
        <th>Wartość</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <b> <td>Id</td> </b>
        <td>${user.getId()}</td>
    </tr>
    <tr>
      <b>  <td>Name</td></b>
        <td>${user.getUserName()}</td>
    </tr>
    <tr>
       <b> <td>Email</td> </b>
        <td>${user.getEmail()}</td>
    </tr>
    </tbody>
</table>
    <button onclick="window.location='/user/list'">Okay</button>

<jsp:include page="../theme/footer.jsp"/>
