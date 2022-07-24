import IndexPageLayout from "../layout/IndexPageLayout";
import { getAllProducts } from "../helpers/products-api-utils";
import {Product} from '../models/Product';
import {useDispatch,useSelector} from 'react-redux';
import {State} from '../store/reducers/rootReducers';

interface Props{
  allProduct : Product[]; 
}
const Home = (props:any) => {
  const dispatch = useDispatch();
  // const { addItem, removeItem, decreamentItem } = bindActionCreators(
  //   ActionCreators,
  //   dispatch
  // );

  const list = useSelector((state:State)=> state.cartreducer);

  return (
    <div>
      <IndexPageLayout products={props.products} />
    </div>
  );
}

export async function getStaticProps() {
  const allproducts = await getAllProducts();
  return {
    props: {
      products: allproducts,
    },
    revalidate: 60,
  };
}

export default Home
