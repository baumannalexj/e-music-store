<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detailed information of the product</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.id}.png" />" alt="image"
                             style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>${product.manufacturer}</p>
                    <p>${product.category}</p>
                    <p>${product.condition}</p>
                    <p>${product.price}</p>
                </div>
            </div>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
