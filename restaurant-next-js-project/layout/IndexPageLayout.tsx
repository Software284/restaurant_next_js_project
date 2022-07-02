
import Products from '../components/products/products';
import Auxiliary from '../hoc/Auxiliary';
function IndexPageLayout(){
    return(
        <Auxiliary>
            <Products />
        </Auxiliary>
    );
}
export default IndexPageLayout;