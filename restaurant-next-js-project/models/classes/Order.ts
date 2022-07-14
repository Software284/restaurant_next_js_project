import {Address} from './Address';
import {CartProduct} from './CartProduct';
import { Customer } from './Customer';
export class Order {
    id:number;
    totalprice:number;
    cartdata: CartProduct[];
    customer:Customer;

    constructor(id:number,totalprice:number,cartdata:CartProduct[],customer:Customer){
        this.id = id;
        this.totalprice = totalprice;
        this.cartdata = cartdata;
        this.customer = customer;
    }

    set setId(id:number){
        this.id = id;
    }
    get getId(){
        return this.id;
    }
    set setTotalprice(totalprice:number){
        this.totalprice = totalprice;
    }
    get getTotalprice(){
        return this.totalprice
    }
    set setCartdata(cartdata:CartProduct[]){
        this.cartdata = cartdata
    }
    get getCartdata(){
        return this.cartdata;
    }
    set setCustomer(customer:Customer){
        this.customer = customer;
    }
    get getCustomer(){
        return this.customer;
    }

    
}