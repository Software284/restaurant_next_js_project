export class FavouritesProduct {
  id?: number;
  name: string;
  price: number;
  quantity: number;
  image: string;
  username: string;

  constructor(id:number,name:string,price:number,quantity:number,image:string,username:string){
    this.id = id;
    this.name = name;
    this.price= price;
    this.quantity = quantity;
    this.image = image;
    this.username = username;
  }

  set setId(id:number){
    this.id = id;
  }
 
  get getName(){
    return this.name;
  }

  set setName(name:string){
    this.name = name;
  }

  get getPrice(){
    return this.price;
  }

  set setPrice(price:number){
    this.price = price;
  }

  get getQuantity(){
    return this.quantity;
  }

  set setQuantity(quantity:number){
    this.quantity = quantity;
  }

  get getImage(){
    return this.image;
  }

  set setImage(image:string){
    this.image = image;
  }

  get getUsername(){
    return this.username;
  }

  set setUsername(username:string){
    this.username = username;
  }
}