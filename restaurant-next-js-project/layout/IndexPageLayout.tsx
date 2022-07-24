import Products from '../components/Products/products';


function IndexPageLayout(props:any){
    return (
      <div>
        <Products products={props.products} />
      </div>
    )
}
export default IndexPageLayout;