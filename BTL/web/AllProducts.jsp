<%@page import="session_bean.CustomerSessionBean"%>
<%@page import="entity.Customer"%>
<%@page import="java.util.List"%>

<%
    session.setAttribute("view", "/AllProducts");
%>

<div class="container-fluid">
    <div class="row">
        <!-- left -->
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
        </div>
        <!-- Content -->

        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
            <h4 class="headline">All Products</h4>
            <br>
            <p>Please click the Id number to see more detail!</p>
            <hr>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>Product Id</th>
                    <th>Product Name</th>
                    <th>Last update</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${AllProducts}" varStatus="iter">
                    <tr>
                        <td>${iter.count }</td>
                        <td><a href="<c:url value='product?${product.getProductId()}'/>">${product.getProductId()}</td>
                        <td>${product.getName()}</td>
                        <td>${product.getLastUpdate()}</td>
                        <td>${product.getPrice()}</td>
                        <td>${product.getQuantity()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

        <div></div>

        <!-- Cart -->
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
    </div>
</div>

