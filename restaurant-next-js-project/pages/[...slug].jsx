import { useRouter } from 'next/router';
import ErrorAlert from '../components/UI/ErrorAlert/ErrorAlert';
import {getFilterProducts} from '../helpers/products-api-utils';
import ProductSearch from '../components/ProductSearch/ProductSearch';
import Products from '../components/Products/products';
function ProductSearchSlug(props){
  const router = useRouter();
  const filterData = router.query.slug;

  if(!filterData){
    return <p style={{textAlign:'center'}}>Loading...</p>
  }


  const myFilterProducts = props.product;

  let navigating_data = <Products products={myFilterProducts} />;
   if (props.hasError) {
      navigating_data = <ErrorAlert>Product Not Found</ErrorAlert>;
   }




  return (
    <>
      <ProductSearch data1={filterData[0]} data2={filterData[1]}/>
      {navigating_data}
     
    </>
  );
 

}

  export async function getServerSideProps(context) {
    const { params } = context;
    const filterData = params.slug;

    const filterFood = filterData[0];
    const filterPrice = filterData[1];

    const filterProduct = await getFilterProducts({
      price_range: filterPrice,
      type: filterFood,
    });
    console.log(filterProduct);

    if (filterProduct.length === 0) {
      return {
        props:{
          hasError:true
        }
      }
    }


    return {
      props: {
        product: filterProduct,
      },
    };
  }
export default ProductSearchSlug;