
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Show products list</a>
<h1>Delete product form</h1>
<form method="post">
    <div>
        <p>${product.product_name}</p>
    </div>
    <div>
        <p>${product.product_code}</p>
    </div>

    <div>
        <p>${product.description}</p>
    </div>

    <div>
        <p>${product.product_price}</p>
    </div>

    <div>
        <p>${product.product_image}</p>
    </div>

    <div>
        <p>${product.product_inventory}</p>
    </div>

    <div>
        <p>${product.category_id}</p>
    </div>

    <div>
        <p>${product.brand_id}</p>
    </div>
    <button>Delete</button>
</form>
</body>
</html>