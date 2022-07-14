export class CartProduct {
  id:number;
  name:string;
  price:number;
  quantity:number;
  image:string;

  constructor(id:number,name:string,price:number,quantity:number,image:string){
    this.id= id;
    this.name=name;
    this.price=price;
    this.quantity=quantity;
    this.image = image;
  }

  get getId(){
    return this.id;
  }
  get getName(){
    return this.name;
  }
  get getPrice(){
    return this.price;
  }
  get getQuantity(){
    return this.quantity;
  }
  get getImage(){
    return this.image;
  }
  set setId(id:number){
    this.id = id;
  }
  set setName(name:string){
    this.name=name;
  }
  set setPrice(price:number){
    this.price = price;
  }

  set setQuantity(quantity:number){
    this.quantity =quantity;
  }
  set setImage(image:string){
    this.image = image;
  }
}
