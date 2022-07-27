export async function getAllProducts() {
  const response = await fetch("http://localhost:8080/restaurant/product");
  const data = await response.json();
  

  const products = [];
  for (const key in data) {
     products.push({
      ...data[key],
    });
  }

  return products;
}

export async function getProductsById(id:any) {
  const products = await getAllProducts();
  const data = products.find((product) => product.id.toString() === id);
  return data;
}

export async function getFilterProducts(Pro: any) {
  const { price_range, type } = Pro;
  const allProducts = await getAllProducts();
 console.log(price_range);
 console.log(type);
  let filterProducts;
  if (price_range == "All Products" && type == "All Products") {
    filterProducts = allProducts.filter((product) => {
      return price_range === "All Products" || type === "All Products";
    });
  }
  else if(type === "All Products" && price_range !== "All Products"){
     filterProducts = allProducts.filter((product) => {
       return price_range === product.price_range;
     });
  }
  else if(type !== "All Products" && price_range === "All Products"){
    filterProducts = allProducts.filter((product) => {
      return type === product.type;
    });
  }
  else {
     filterProducts = allProducts.filter((product) => {
       return product.price_range === price_range && product.type === type;
     });
  }


  return filterProducts;
}
