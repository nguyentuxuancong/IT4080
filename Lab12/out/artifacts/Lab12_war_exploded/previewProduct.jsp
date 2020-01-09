<link rel="stylesheet" type="text/css" href="sliderengine/amazingslider-1.css">
<script src="sliderengine/jquery.js"></script>
<script src="sliderengine/amazingslider.js"></script>
<script src="sliderengine/initslider-1.js"></script>
<%@page import="entity.ProductDetail" %>
<%@page import="entity.Product" %>
<%
    session.setAttribute("view", "/product ");
    Product selectedProduct = (Product)
            session.getAttribute("selectedProduct");
    ProductDetail selectedProductDetail = (ProductDetail)
            session.getAttribute("selectedProductDetail");
%>
<div id="container">
    <div class="one">
        <div class="heading_bg">
            <h2>
                <%=selectedProduct.getName()%>
            </h2>
        </div>
    </div>
    <div class="one-half">
        <div id="amazingslider-wrapper-1"
             style="display:block;position:relative;max-width:450px;margin:0px auto
98px;">
            <div id="amazingslider-1"
                 style="display:block;position:relative;margin:0 auto;">
                <ul class="amazingslider-slides" style="display:none;">
                    <%
                        for (String img :
                                selectedProductDetail.getAllImages()) {
                    %>
                    <li><a href="images/<%=img%>" class="html5lightbox"><img src="images/<%=img%>" alt="" title=""/></a></li>
                    <%
                        }
                    %>
                </ul>
                <ul class="amazingslider-thumbnails" style="display:none;">
                    <%
                        for (String img :
                                selectedProductDetail.getAllImages()) {
                    %>
                    <li><img src="images/tn-<%=img%>" alt="" title=""
                    /></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
    <div class="one-half last">
        <ul id="tabify_menu" class="menu_tab" style="margin: 0;">
            <li><a href="#fane1">Product Details</a></li>
        </ul>
        <div id="fane1" class="tab_content">
            <h3>Technical Details</h3>
            <p>
                <%=selectedProductDetail.getInformation()%>
            </p>
            <h3>Accessories</h3>
            <p><%=selectedProductDetail.getAccessories()%>
            </p>
            <h3>Warranty Strategy</h3>
            <p><%=selectedProductDetail.getGuaranty()%>
            </p>
            <h3>Price</h3>
            <p><%=selectedProduct.getPrice()%> $</p>
            <p style="text-align:left; margin-right: 16px">
                <a href="#" class="button">Add to database</a>
            </p>
        </div>
    </div>
    <div style="clear:both; height: 40px"></div>
</div>