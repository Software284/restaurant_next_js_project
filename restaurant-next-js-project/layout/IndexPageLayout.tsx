import { Product } from '../models/Product';
import Products from '../components/products/products';
import Auxiliary from '../hoc/Auxiliary';

function IndexPageLayout(props:any){
    return(
        <Auxiliary>
            <Products products={props.products}/>
        </Auxiliary>
    );
}
export default IndexPageLayout;