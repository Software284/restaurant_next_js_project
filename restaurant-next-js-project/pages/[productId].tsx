import { getAllProducts,getProductsById } from "../helpers/products-api-utils";
import ErrorAlert from "../components/UI/ErrorAlert/ErrorAlert";
import Auxiliary from "../hoc/Auxiliary";
import ProductContent from "../components/ProductContent/ProductContent";
function ProductDescription(props:any){
     const product = props.selectedProduct;
        if(!product){
            return(
                <ErrorAlert>
                    <p>No product found!!!</p> 
                </ErrorAlert>
            );
        }

    return (
      <Auxiliary>
        <ProductContent data={product} />
      </Auxiliary>
    );
}
export async function getStaticProps(context:any){
    const productId = context.params.productId;
    const product = await getProductsById(productId);
    return{
        props:{
            selectedProduct:product
        },
        revalidate:60,
    };

}


export async function getStaticPaths(){
    const products = await getAllProducts();
    const paths = products.map((product) => ({
      params: { productId: product.id.toString()},
    }));
    return {
        paths: paths,
        fallback: false
    };
}
export default ProductDescription;