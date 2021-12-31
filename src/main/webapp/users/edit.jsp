<%--
  Created by IntelliJ IDEA.
  User: kucin
  Date: 31/12/2021
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../theme/header.jsp"/>

<form  method="post" class="m-auto" style="max-width:600px">
    <h3 class="my-4">Edit User</h3>
    <hr class="my-4" />
    <div class="form-group mb-3 row"><label for="name2" class="col-md-5 col-form-label">Name</label>
        <div class="col-md-7"><input type="text" class="form-control form-control-lg" id="name2" name="name" value="${user.getUserName()}" required></div>
    </div>
    <div class="form-group mb-3 row"><label for="email3" class="col-md-5 col-form-label">Email</label>
        <div class="col-md-7"><input type="email" class="form-control form-control-lg" id="email3" name="email" value="${user.getEmail()}" required><small class="form-text text-muted"> Please enter a valid email address</small></div>
    </div>
    <hr class="bg-transparent border-0 py-1" />
    <div class="form-group mb-3 row"><label for="pasword6" class="col-md-5 col-form-label">Password</label>
        <div class="col-md-7"><input type="password" class="form-control form-control-lg" id="pasword6" name="password" required><small class="form-text text-muted"> Please enter a password at least 8 characters long</small></div>
    </div>
    <hr class="my-4" />
    <div class="form-group mb-3 row"><label class="col-md-5 col-form-label"></label>
        <div class="col-md-7"><button class="btn btn-primary btn-lg" type="submit">Edit User!</button></div>
    </div>
</form>


<jsp:include page="../theme/footer.jsp"/>