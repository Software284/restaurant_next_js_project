import {Address} from './Address';
import {DemoCartProduct} from './DemoCartProduct';
import { Customer } from './Customer';
export class OrderDemo {
  totalprice: number;
  ingredients: DemoCartProduct[];
  customer: Customer;

  constructor(
    totalprice: number,
    ingredients: DemoCartProduct[],
    customer: Customer
  ) {
    this.totalprice = totalprice;
    this.ingredients = ingredients;
    this.customer = customer;
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