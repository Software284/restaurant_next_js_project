import Navigation from '../components/Navigation/navigation';
import Products from '../components/products/products';
import Auxiliary from '../hoc/Auxiliary';
function IndexPageLayout(){
    return(
        <Auxiliary>
            <Navigation />
            <Products />
        </Auxiliary>
    );
}
export default IndexPageLayout;