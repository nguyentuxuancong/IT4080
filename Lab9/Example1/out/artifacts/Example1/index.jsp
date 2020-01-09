<div id="container">
    <div id="prod_wrapper">
        <div id="panes">
            <c:forEach var="product" items="${newProducts}">
                <div>
                    <img src="${initParam.imgProductPath}${product.getImage()}" width="200" height="200" alt="">
                    <h5>${product.getName()}</h5>
                    <p>${product.getDescription()}</p>
                    <p style="text-align:right; margin-right:16px">
                        <a hrefs="#" class="button">More Info</a>
                        <a hrefs="#" class="button">Buy Now</a>
                    </p>
                </div>
            </c:forEach>
        </div>
        <!— END tab panes —>
        <br clear="all">
        <!— navigator —>
        <div id="prod_nav">
            <ul>
                <c:set var="countProduct" scope="request" value="${l}"/>
                <c:forEach var="product" items="${newProducts}">
                    <li>
                        <a href="#${countProduct}">
                            <img src="${initParam.imgProductPath}${product.getThumbImage()}" alt="">
                            <strong>${product.getName()}</strong> $ ${product.getPrice()}
                        </a>
                    </li>
                    <c:set var="countProduct" scope="request" value="${countProduct+l}"/>
                </c:forEach>
            </ul>
        </div>
        <!— close navigator —>
    </div>

    <div style="clear:both"></div>
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>Mac</h2>
        </div>
        <img src="img/demo/4.jpg" width="217" alt="">
    </div>
    <!---- Second Column ---->
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>ipad</h2>
        </div>
        <img src="img/demo/6.jpg" width="217" alt="">
    </div>
    <!---- Third Column ---->
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>iPhone</h2>
        </div>
        <img src="img/demo/3.jpg" width="217" alt="">
    </div>
    <!---- Fourth Column ---->
    <div class="one-fourth last">
        <div class="heading_bg">
            <h2>Accessories</h2>
        </div>
        <img src="img/demo/1.jpg" width="217" alt="">
    </div>
    <div style="clear:both; height:40px"></div>
</div>