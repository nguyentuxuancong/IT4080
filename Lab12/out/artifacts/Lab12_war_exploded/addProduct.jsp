<c:set var='view' value='/checkout' scope='session' />
<script src="js/jquery.validate.js" type="text/javascript"></script>
<div id="container">

        <div class="heading_bg">
            <h2>Add Product</h2>
        </div>
        <form id="checkoutForm" action="<c:url value='addProduct' />"
              method="post">
            <br>
                <label>Name</label></br>
                <input type="text" name="name" id="name" />
            </fieldset>
            <fieldset>
                <label>Price</label></br>
                <input type="text" name="price" id="price" />
            </fieldset>
            <fieldset>
                <label>Description</label></br>
                <input type="text" name="description" id="description" />
            </fieldset>
            <fieldset>
                <label>Category Id</label></br>
                <input type="number" name="categoryId" id="categoryId" />
            </fieldset>
            <fieldset>
                <label>Image</label></br>
                <input type="file" name="image" id="image"/>
            </fieldset>
            <fieldset>
                <label>Description Detail</label></br>
                <input type="text" name="description_detail" id="description_detail"/>
            </fieldset>
            <fieldset>
                <label>Information</label></br>
                <input type="text" name="information" id="information"/>
            </fieldset>
            <fieldset>
                <label>Image1</label></br>
                <input type="file" name="image1" id="image1"/>
            </fieldset>
            <fieldset>
                <label>Image2</label></br>
                <input type="file" name="image2" id="image2"/>
            </fieldset>
            <fieldset>
                <label>Image3</label></br>
                <input type="file" name="image3" id="image3"/>
            </fieldset>
            <fieldset>
                <label>Image4</label></br>
                <input type="file" name="image4" id="image4"/>
            </fieldset>
            <fieldset>
                <label>Image5</label></br>
                <input type="file" name="image5" id="image5"/>
            </fieldset>
            <fieldset>
                <label>Accessories</label></br>
                <input type="text" name="accessories" id="accessories"/>
            </fieldset>
            <fieldset>
                <label>Guaranty</label></br>
                <input type="text" name="guaranty" id="guaranty"/>
            </fieldset>
            <fieldset>
                <input value="Submit" class="button white" type="submit">
            </fieldset>
        </form>
</div>