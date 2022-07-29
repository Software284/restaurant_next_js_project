import IndexPageLayout from "../layout/IndexPageLayout";
import { getAllProducts } from "../helpers/products-api-utils";
import {Product} from '../models/Product';
import {useDispatch,useSelector} from 'react-redux';
import {State} from '../store/reducers/rootReducers';
import { bindActionCreators } from "redux";
import * as ActionCreators from '../store/actions/auth/action-creators';

interface Props{
  allProduct : Product[]; 
}
const Home = (props:any) => {

  const auth_reducer = useSelector((state: State) => state.authreducer);
  const dispatch = useDispatch();
  const {  } = bindActionCreators(
    ActionCreators,
    dispatch
  );

  const list = useSelector((state:State)=> state.cartreducer);

  return (
    <div>
      {console.log(auth_reducer.token+":"+auth_reducer.user)}
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
