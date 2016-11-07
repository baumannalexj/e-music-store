<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/template/header.jsp" %>

<%@page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Check out our list of products available!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumbnail</th>
                <th>Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>

            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="#" alt="image"/></td>
                    <td>${product.name}</td>
                    <td>${product.category}</td>
                    <td>${product.condition}</td>
                    <td><span>${product.price}</span></td>
                    <td><a href="<spring:url value="/products/viewProduct/${product.id}"/>">
                        <span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
