<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kucin
  Date: 28/12/2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../theme/header.jsp"/>

    <button type="button" value="adduser" name="adduser" onclick="window.location='/user/add'">Add New User</button>
    <table class="cinereousTable">
        <thead>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
           <tr>
               <td> ${user.getId()} </td>
               <td> ${user.getUserName()} </td>
               <td> ${user.getEmail()} </td>
               <td>
                   <a href="/user/delete?id=${user.getId()}">Delete</a>
                   <a href="/user/edit?id=${user.getId()}">Edit</a>
                   <a href="/user/show?id=${user.getId()}">Show</a>
               </td>
           </tr>
        </c:forEach>
        </tbody>
    </table>


<jsp:include page="../theme/footer.jsp"/>