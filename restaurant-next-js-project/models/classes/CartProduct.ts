export class CartProduct {
  id?:number;
  name:string;
  price:number;
  quantity:number;
  image:string

  constructor(id:number,name:string,price:number,quantity:number,image:string){
    this.id = id;
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
}
