import { Address } from "./Address";
import { DemoCartProduct } from "./DemoCartProduct";
import { Customer } from "./Customer";
export class Order {
  id:number;
  totalprice: number;
  ingredients: DemoCartProduct[];
  customer: Customer;

  constructor(
    id:number,
    totalprice: number,
    ingredients: DemoCartProduct[],
    customer: Customer
  ) {
    this.id = id;
    this.totalprice = totalprice;
    this.ingredients = ingredients;
    this.customer = customer;
  }

  set setId(id:number){
    this.id = id;
  }
  get getId(){
    return this.id;
  }

  set setTotalprice(totalprice: number) {
    this.totalprice = totalprice;
  }
  get getTotalprice() {
    return this.totalprice;
  }
  set setIngredients(ingredients: DemoCartProduct[]) {
    this.ingredients = ingredients;
  }
  get getIngredients() {
    return this.ingredients;
  }
  set setCustomer(customer: Customer) {
    this.customer = customer;
  }
  get getCustomer() {
    return this.customer;
  }
}
