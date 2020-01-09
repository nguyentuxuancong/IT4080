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

<!-- AMAZING SLIDER -->

<div class="bd-example">
    <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">
        <div class="carousel-inner">
            <c:set var="countProduct" scope="request" value="${0}"/>
            <c:forEach var="product" items="${mostProducts}">
                <c:choose>
                    <c:when test="${countProduct == 0}">
                        <div class="carousel-item active" data-interval="3000">
                            <img src="${initParam.imgProductPath}${product.getImage()}" class="d-block w-100" style="max-height:700px;"
                                 alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h1 style="color: red">${product.getName()} $${product.getPrice().toString()}</h1>
                                <a href="<c:url value='product?${product.getProductId()}'/>"><button>More Info</button></a>
                                <c:if test="${product.getQuantity() > 0}">
                                    <a href="<c:url value='addToCart?${product.getProductId()}'/>"><button>Buy now</button></a>
                                </c:if>
                            </div>
                        </div>
                        <c:set var="countProduct" scope="request" value="${countProduct + 1}"/>
                    </c:when>
                    <c:otherwise>
                        <div class="carousel-item" data-interval="3000">
                            <img src="${initParam.imgProductPath}${product.getImage()}" class="d-block w-100" style="max-height:700px;"
                                 alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h1 style="color: red">${product.getName()} $${product.getPrice().toString()}</h1>
                                <a href="<c:url value='product?${product.getProductId()}'/>"><button>More Info</button></a>
                                <c:if test="${product.getQuantity() > 0}">
                                    <a href="<c:url value='addToCart?${product.getProductId()}'/>"><button>Buy now</button></a>
                                </c:if>
                            </div>
                        </div>
                        <c:set var="countProduct" scope="request" value="${countProduct + 1}"/>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions"
           role="button" data-slide="prev"> <span
                class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                class="sr-only">Previous</span>
        </a> <a class="carousel-control-next" href="#carouselExampleCaptions"
                role="button" data-slide="next" > <span
            class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="sr-only">Next</span>
    </a>
    </div>
</div>

<!-- CONTENT -->

<div class="container-fluid">
    <div class="row">
        <!-- mid -->
        <div class="Content col-lg-10 col-md-10 col-sm-9 col-xs-12" style="margin: auto">
            <!-- product -->
            <div>
                <hr>
                <h1>Current Offers</h1>
                <hr>
                <div class="row">
                    <c:set var="countProduct" scope="request" value="${1}"/>
                    <c:forEach var="product" items="${newProducts}">
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
            <!-- category -->
            <div style="margin-top: 100px;">
                <hr>
                <div>
                    <h1>Category</h1>
                </div>
                <hr>
                <div class="row">
                    <c:set var="countCategory" scope="request" value="${1}"/>
                    <c:forEach var="category" items="${newCategories}">
                        <div class="col-xs-6 col-sm-6 col-md-4 col-lg-3">
                            <div class="GirdProduct">
                                <div style="height: 220px;" class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="panel-product-image">
                                            <a href="<c:url value='category?${category.categoryId}'/>">
                                                <div>
                                                    <img style="width: 100%; height: 100%; justify-content: center; align-items: center; -webkit-box-pack: center; -webkit-box-align: center; position: absolute; background: rgb(255, 255, 255); top: 0px; left: 0px;"
                                                         src="${initParam.imgCategoryPath}${category.getImage()}"
                                                         alt="">
                                                </div>
                                            </a>
                                        </div>
                                        <div style="margin-left: 10px;" class="panel-body-text">
                                            <div align="center" style="margin-top:14px;" class="panel-body-heading">
                                                <h4 class="panel-product-name">${category.getName()}</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:set var="countCategory" scope="request"
                               value="${countCategory+1}"/>
                    </c:forEach>
                    <div style="clear: both; margin-top: 200px;"></div>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>

