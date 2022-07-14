import {CartProduct} from './CartProduct';
import { Customer } from './Customer';
export interface Order {
    id:number;
    totalprice:number;
    cartdata: CartProduct[];
    customer:Customer;
}