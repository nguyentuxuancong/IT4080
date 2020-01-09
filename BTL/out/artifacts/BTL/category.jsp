<c:set var="pageTitle" scope="request" value="${title}"/>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%
	session.setAttribute("view", "/category");
	Category category = (Category) session.getAttribute("selectedCategory");
%>
<hr>
<div class="container-fluid">
	<div class="row">
		<div class="Content col-lg-10 col-md-10 col-sm-9 col-xs-12">
			<!-- product -->
			<div>
				<hr>
				<div>
					<h1><%=category.getName()%></h1>
				</div>
				<hr>
				<div class="container">
					<div class="row row-cols-4">						
							<%
								List<Product> categoryProducts = (List<Product>) session.getAttribute("categoryProducts");
								for (Product p : categoryProducts) {
							%>
								<div class="col">	
										<p>
											<a title="<%=p.getName()%>" href="img/demo/<%=p.getImage()%>" class="portfolio-item-preview" datarel="prettyPhoto"> 							
											<img src="img/demo/<%=p.getImage()%>" alt="" width="210" height="145" class="portfolio-img pretty-box">
											</a>
										</p>
										<h4><a href="#"><%=p.getName()%></a></h4>
										<c:if test="${account == 1 }">
											<p>Quantity in stock: <%=p.getQuantity()%></p>
										</c:if>									
										<p><%=p.getDescription()%></p>
										<p style="text-align: left">
											<a href="product?<%=p.getProductId()%>" class="button_small white">See Details &raquo;</a>
										</p>
								</div>
							<%
								}
							%>					
					</div>
				</div>
			</div>
			<div style="clear: both; height: 40px"></div>
		</div>
</div>
</div>
