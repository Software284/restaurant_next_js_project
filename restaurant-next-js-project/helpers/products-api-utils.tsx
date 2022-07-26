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

export async function getFilterProducts(proFilter: any) {
  const { type, price_range } = proFilter;
  console.log(price_range);
  console.log(type);
  const allProducts = await getAllProducts();
  const filterProduct = allProducts.filter((product) => {
    return product.price_range == price_range && product.type == type;
  });
  console.log("Hello=" + filterProduct);
  return filterProduct;
}
