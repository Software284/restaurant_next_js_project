import Products from '../components/Products/products';
import ProductSearch from '../components/ProductSearch/ProductSearch';


function IndexPageLayout(props:any){
    return (
      <div>
        <ProductSearch/>
        <Products products={props.products} />
      </div>
    )
}
export default IndexPageLayout;