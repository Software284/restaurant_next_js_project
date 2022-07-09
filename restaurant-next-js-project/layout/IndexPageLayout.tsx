import Products from '../components/products/products';
import ContactData from '../pages/admin/ContactData/ContactData';


function IndexPageLayout(props:any){
    return (
      <div>
        <Products products={props.products} />
      </div>
    )
}
export default IndexPageLayout;