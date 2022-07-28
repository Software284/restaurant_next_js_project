import { Address } from "./Address"
import {Order} from './Order';
export interface Customer {
    id:number;
    name:string;
    email:string;
    gender:string;
    address:Address;
    order:Order;
}