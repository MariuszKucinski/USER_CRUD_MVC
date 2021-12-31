<%--
  Created by IntelliJ IDEA.
  User: kucin
  Date: 31/12/2021
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../theme/header.jsp"/>

<form method="post" class="m-auto" style="max-width:600px">
    <h3 class="my-4">Delete User</h3>
    <hr class="my-4" />
    <div class="form-group mb-3 row"><label  class="col-md-5 col-form-label">Choose Option</label>
        <div class="col-md-7">
            <div class="form-check custom-control custom-radio"><input class="form-check-input custom-control-input" type="radio" name="delete" id="choose-option2_2" checked value="yes"><label class="form-check-label custom-control-label" for="choose-option2_2">Yes</label></div>
            <div class="form-check custom-control custom-radio"><input class="form-check-input custom-control-input" type="radio" name="delete" id="choose-option2_3" value="no"><label class="form-check-label custom-control-label" for="choose-option2_3">No</label></div>
        </div>
    </div>
    <hr class="my-4" />
    <div class="form-group mb-3 row"><label class="col-md-5 col-form-label"></label>
        <div class="col-md-7"><button class="btn btn-primary btn-lg" type="submit">Take action!</button></div>
    </div>
</form>


<jsp:include page="../theme/footer.jsp"/>

