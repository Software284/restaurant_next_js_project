class Ingredient {
  name?: string;
  price?: number;
  quantity?: number;
  image?: string;

  constructor(){
   
  }

//   constructor(name: string, price: number, quantity: number, image: string) {
//     this.name = name;
//     this.price = price;
//     this.quantity = quantity;
//     this.image = image;
//   }

  set setName(name: string) {
    this.name = name;
  }
  set setPrice(price: number) {
    this.price = price;
  }
  set setQuantity(quantity: number) {
    this.quantity = quantity;
  }
  set setImage(image: string) {
    this.image = image;
  }

  get getName() {
    return this.name;
  }
  get getPrice() {
    return this.price;
  }
  get getQuantity() {
    return this.quantity;
  }
  get getImage() {
    return this.image;
  }
}
export default Ingredient;