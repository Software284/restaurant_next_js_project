import IndexPageLayout from "../layout/IndexPageLayout";
import { getAllProducts } from "../helpers/products-api-utils";
import {Product} from '../models/Product';
import { CartProduct } from "../models/CartProduct";

import {useDispatch,useSelector} from 'react-redux';
import {bindActionCreators} from 'redux';
import * as ActionCreators from '../store/actions/action-creators';
import {State} from '../store/reducers/rootReducers';

interface Props{
  allProduct : Product[]; 
}
const Home = (props:any) => {
  const dispatch = useDispatch();
  const { addItem, removeItem, decreamentItem } = bindActionCreators(
    ActionCreators,
    dispatch
  );

  const list = useSelector((state:State)=> state.cartreducer);

  return (
    <div>
      {/* <div>
        <ul>
          {list.carts.map((data: CartProduct) => (
            <li key={data.id}>
              {data.id}:{data.name}:{data.price}:{data.quantity}
            </li>
          ))}
        </ul>
        <button
          onClick={() =>
            addItem({ id: 2, price: 200, name: "chaumin", quantity: 1 })
          }
          style={{ padding: "10px 20px", background: "red", margin: "10px" }}
        >
          AddItem
        </button>
        <button
          onClick={() =>
            addItem({ id: 3, price: 200, name: "momo", quantity: 1 })
          }
          style={{ padding: "10px 20px", background: "red", margin: "10px" }}
        >
          AddItem2
        </button>
        <button
          onClick={() => removeItem(2)}
          style={{ padding: "10px 20px", background: "red", margin: "10px" }}
        >
          WITHDRAW
        </button>
        <button
          onClick={() =>
            decreamentItem({ id: 2, price: 200, name: "chaumin", quantity: 1 })
          }
          style={{ padding: "10px 20px", background: "red", margin: "10px" }}
        >
          DECREAMENT
        </button>
      </div> */}
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
  };
}

export default Home
