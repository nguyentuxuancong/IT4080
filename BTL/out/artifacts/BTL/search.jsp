<%--<script src="js/jquery.tools.min.js"></script>--%>
<script>
    $(function () {
        $("#prod_nav ul").tabs("#panes > div", {
            effect: 'fade',
            fadeOutSpeed: 400
        });
    });
</script>
<script>
    $(document).ready(function () {
        $(".pane-list li").click(function () {
            window.location = $(this).find("a").attr("href");
            return false;
        });
    });
</script>
<c:set var='view' value='/index' scope='session'/>

<!-- CONTENT -->

<div class="container-fluid">
    <div class="row">
        <!-- mid -->
        <div class="Content col-lg-10 col-md-10 col-sm-9 col-xs-12" style="margin: auto">
            <!-- product -->
            <div>
                <hr>
                <h1>Results</h1>
                <hr>
                <div class="row">
                    <c:set var="countProduct" scope="request" value="${1}"/>
                    <c:forEach var="product" items="${resultProducts}">
                        <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3">
                            <div class="GirdProduct">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="panel-product-image">
                                            <a href="<c:url value='product?${product.productId}'/>">
                                                <div>
                                                    <img style="width: 100%; height: 100%; justify-content: center; align-items: center; -webkit-box-pack: center; -webkit-box-align: center; position: absolute; background: rgb(255, 255, 255); top: 0px; left: 0px;"
                                                         src="${initParam.imgProductPath}${product.getImage()}" alt="">
                                                </div>
                                            </a>
                                        </div>
                                        <div style="margin-left: 10px;" class="panel-body-text">
                                            <div class="panel-body-heading">
                                                <h4 class="panel-product-name">${product.getName()}</h4>
                                            </div>
                                            <div class="panel-body-cart-price-area row">
                                                <div class="panel-body-addtocart col-6">
                                                    <div style="position: relative;">
                                                        <div class="loadable-content-wrap">
                                                            <c:choose>
                                                                <c:when test="${product.getQuantity() > 0}">
                                                                    <a href="<c:url value='addToCart?${product.productId}'/>"
                                                                       style="background-color: white;" type="button"
                                                                       class="btn btn-primary button">
                                                                        <img class="InlineIcon" src="img/cart.png"
                                                                             viewBox="0 0 36 36" width="36">
                                                                    </a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="#" style="background-color: white;"
                                                                       type="button" class="btn btn-primary button">
                                                                        <img class="InlineIcon" src="img/outofstock.JPG"
                                                                             viewBox="0 0 36 36" width="36" height="36">
                                                                    </a>

                                                                </c:otherwise>
                                                            </c:choose>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div style="margin: 7px 0px 0px 20px" class="panel-product-price col">
                                                    $${product.getPrice()}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-footer">
                                        <p style="margin-left: 10px;">${product.getDescription() }</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:set var="countProduct" scope="request"
                               value="${countProduct+1}"/>
                    </c:forEach>
                    <div style="clear: both; margin-top: 200px;"></div>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>

