<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 11/17/19
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!--CSS -->
  <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
  <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
  <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen">
  <link rel="stylesheet" href="boxes/css/style6.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="js/fancybox/jquery.facybox.css" media="all">

</head>
<html>
<body>
<div id="container">
  <div id="prod_wrapper">
    <div class="ei-slider-element">
      <c:forEach var ="product" items="${newProduct}">
        <div>
<%--          <h1>${product.getImage()}</h1>--%>
          <img src="${initParam.imgProductPath}${product.getImage()}" alt="">
          <h5>${product.getName()}</h5>
          <p>${product.getDescription()}</p>
          <p style="text-align: right; margin-right: 16px">
            <a href="#" class="button">More Info</a>
            <a href="#" class="button">Buy now</a>
          </p>
        </div>
      </c:forEach>
    </div>

    <!--End tab panes -->
    <div id="prod_nav">
      <ul>
        <c:set var="countProduct" scope="request" value="${1}"/>
        <c:forEach var="product" items="${newProducts}">
          <li>
            <a href="#${countProduct}">
              <img src="${initParam.imgProductPath}${product.getThumbImage()}" alt="" width="100" height="50">
              <strong>${product.getName()}</strong> $${product.getPrice()}
            </a>
          </li>
          <c:set var="countProduct" scope="request" value="${countProduct+1}" />
        </c:forEach>
      </ul>
    </div>
    <!--close navigator -->
  </div>
  <div style="clear:both">
    <!--First -->
    <div class="one-fourth">
      <div class="heading_bg">
        <h2>Mac</h2>
      </div>
      <img src="img/demo/4.jpg" width="217" alt="">
    </div>

    <!--Second -->
    <div class="one-fourth">
      <div class="heading_bg">
        <h2>Accessories</h2>
      </div>
      <img src="img/demo/1.jpg" width="217" alt="">
    </div>

    <!--Third -->
    <div class="one-fourth">
      <div class="heading_bg">
        <h2>Ipad</h2>
      </div>
      <img src="img/demo/6.jpg" width="217" alt="">
    </div>

    <!--Fourth -->
    <div class="one-fourth">
      <div class="heading_bg">
        <h2>Iphone</h2>
      </div>
      <img src="img/demo/3.jpg" width="217" alt="">
    </div>

    <div style="clear: both; height: 40px">
    </div>


  </div>
</div>
</body>
</html>

