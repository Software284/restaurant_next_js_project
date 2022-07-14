import { Address } from "./Address"
export interface Customer {
    id?:number;
    name:string;
    email:string;
    gender:string;
    address:Address;
}