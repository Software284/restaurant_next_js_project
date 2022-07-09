import {Address} from './Address';

export interface Order {
    name:string;
    email:string;
    address: Address[];
    loading:boolean;
}