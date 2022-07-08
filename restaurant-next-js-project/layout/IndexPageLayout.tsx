import { Product } from '../models/Product';
import Products from '../components/products/products';
import Auxiliary from '../hoc/Auxiliary';
import OrderSummary from '../components/Order-Summary/OrderSummary';


function IndexPageLayout(props:any){
    return (
      <div>
        <Products products={props.products} />
      </div>
    )
}
export default IndexPageLayout;