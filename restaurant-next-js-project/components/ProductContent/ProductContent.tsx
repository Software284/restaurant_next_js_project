/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable @next/next/no-img-element */
import classes from './ProductContent.module.css';
function ProductContent(props:any) {
  return (
    <section
      id="product-content"
      className={classes.ProductDescriptionContainer}
    >
      <div className={classes.ImageContainer}>
        <img src={props.data.img} alt="product photo" />
      </div>
      <div className={classes.InfoContainer}>
        <h3>{props.data.name}</h3>
        <span>Ratings:{props.data.ratings}</span>
        <span>Price:{props.data.price}</span>
        <p>{props.data.description}</p>
      </div>
    </section>
  );
}
export default ProductContent;
