import IndexPageLayout from "../layout/IndexPageLayout";
import { getAllProducts } from "../helpers/products-api-utils";
import {Product} from '../models/Product';
interface Props{
  allProduct : Product[]; 
}
const Home = (props:any) => {
  return (
    <div>
      <IndexPageLayout products={props.products}/>
    </div>
  )
}

export async function getStaticProps() {
  const allproducts = await getAllProducts();
  return {
    props: {
      products: allproducts,
    },
  };
}

export default Home
