import Products from '../components/products/products';


function IndexPageLayout(props:any){
    return (
      <div>
        <Products products={props.products} />
      </div>
    )
}
export default IndexPageLayout;