export class Address {
    id?:number
    street:string;
    zipcode:number;
    district:string;

    constructor(street:string,zipcode:number,district:string){
        this.street = street;
        this.zipcode = zipcode;
        this.district = district;
    }

    get getId(){
        return this.id;
    }
    get getStreet(){
        return this.street;
    }
    get getZipcode(){
        return this.zipcode;
    }
    get getDistrict(){
        return this.district;
    }

    set setId(id:number){
        this.id= id;
    }
    set setStreet(street:string){
        this.street=street;
    }
    set setZipcode(zipcode:number){
        this.zipcode = zipcode;
    }
    set setDistrict(district:string){
        this.district=district;
    }
}