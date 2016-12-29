<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Edit a product from your inventory</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct"
                   method="post" commandName="product" enctype="multipart/form-data">

            <form:hidden path="id" id="id" value="${product.id}" />
            <p>Product ID: ${product.id}</p>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="name" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category" value="instrument"/>Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category" value="media"/>Media</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category" value="accessory"/>Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="description" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="price" id="price" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline btn btn-default"><form:radiobutton path="condition" id="condition" value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition" value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status" value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status" value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="manufacturer" id="manufacturer" class="form-Control"  />
        </div>

        <div class="form-group">
            <label for="unitsInStock">Units In Stock</label>
            <form:input path="unitsInStock" id="unitsInStock" class="form-Control"  />
        </div>

        <div class="form-group">
            <label for="image" class="control-label">Upload Product Image</label>
            <form:input path="image" id="image" type="file" class="form:input-large" />
        </div>
        <br/>

        <input type="submit" value="Update Product" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
