import { useRouter } from 'next/router';
import IndexPageLayout from '../layout/IndexPageLayout';
import {getFilterProducts} from '../helpers/products-api-utils';
import ErrorAlert from '../components/UI/ErrorAlert/ErrorAlert';
import Products from '../components/Products/products';
function ProductSearchSlug(props){
  const router = useRouter();
  const filterData = router.query.slug;
  if(!filterData){
    return <p style={{textAlign:'center'}}>Loading...</p>
  }

  const myFilterProducts = props.events;

  return (
    <>
      <h1>Slug Page</h1>
      <Products products={myFilterProducts} />
    </>
  );

  // return <IndexPageLayout products={props.products}/>;
 

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

    if (!filterProduct) {
      return <ErrorAlert>Products Not Found</ErrorAlert>;
    }

    return {
      props: {
        product: filterProduct,
      },
    };
  }
export default ProductSearchSlug;