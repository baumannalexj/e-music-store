<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/template/header.jsp" %>

<%@page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is the administrator page.</p>
        </div>

        <div>
            <h3><a href="<c:url value="/admin/productInventory" />">Product Inventory</a></h3>
            <p>View your product inventory. </p>
        </div>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
