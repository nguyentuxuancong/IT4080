<div id="container">
    <div id="prod_wrapper">
        <br clear="all">
        <!— navigator —>
        <div id="prod_nav">
            <ul>
                <c:set var="countCategory" scope="request" value="${l}"/>
                <c:forEach var="category" items="${newCategories}">
                    <li>
                        <a href="#${countCategory}">
                            <img src="${initParam.imgProductPath}${category.getImage()}" width="100" height="100" alt="">
                            <strong>${category.getName()}</strong>
                        </a>
                    </li>
                    <c:set var="countCategory" scope="request" value="${countProciuct+l}"/>
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