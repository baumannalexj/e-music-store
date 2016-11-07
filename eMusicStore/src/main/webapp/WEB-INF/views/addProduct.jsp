<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Add a product to your inventory</p>
        </div>

        <form:form action="#" method="post" commandName="product">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="name" id="name" class="form-Control"/>
        </div>
        </form:form>



        <%@include file="/WEB-INF/views/template/footer.jsp" %>
