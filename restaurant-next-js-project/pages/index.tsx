import IndexPageLayout from "../layout/IndexPageLayout";
import { getAllProducts } from "../helpers/products-api-utils";
import {Product} from '../models/Product';

import {useDispatch,useSelector} from 'react-redux';
import {bindActionCreators} from 'redux';
import {actionCreators} from '../store';



interface Props{
  allProduct : Product[]; 
}
const Home = (props:any) => {
  const dispatch = useDispatch();
  const {depositMoney,withdrawMoney,bankrupt} = bindActionCreators(actionCreators,dispatch);

  return (
    <div>
      <div>

      </div>
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
