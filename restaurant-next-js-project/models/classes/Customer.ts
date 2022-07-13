import { Address } from "./Address"
export class Customer {
    id?:number;
    name:string;
    email:string;
    gender:string;
    address:Address;

    constructor(name:string,email:string,gender:string,address:Address){
        this.name=name;
        this.email=email;
        this.gender=gender;
        this.address=address;
    }

    get getId(){
        return this.id;
    }
    get getName(){
        return this.name;
    }
    get getEmail(){
        return this.email;
    }
    get getGender(){
        return this.gender;
    }
    get getAddress(){
        return this.address;
    }

    set setId(id:number){
        this.id= id;
    }

    set setName(name:string){
        this.name= name;
    }
    set setEmail(email:string){
        this.email = email;
    }
    set setGender(gender:string){
        this.gender = gender;
    }






}