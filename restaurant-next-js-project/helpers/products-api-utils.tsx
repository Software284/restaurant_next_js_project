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
  const blogs = await getAllProducts();
  const data = blogs.find((product) => product.id.toString() === id);
  return data;
}
