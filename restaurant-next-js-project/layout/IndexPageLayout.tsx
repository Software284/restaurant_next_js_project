
import Products from '../components/products/products';
import Auxiliary from '../hoc/Auxiliary';
import {Product} from '../models/Product';
interface Props{
    allproduct: Product[];
}
function IndexPageLayout(props:any){
    return(
        <Auxiliary>
            <Products products={props.products}/>
        </Auxiliary>
    );
}
export default IndexPageLayout;