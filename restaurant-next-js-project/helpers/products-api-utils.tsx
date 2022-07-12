import { Product } from "../models/Product";
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
