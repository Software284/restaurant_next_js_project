import classes from './Order.module.css';
const Order = (props:any) => (
    <div className={classes.Order}>
        <p>Ingredients: Salad(1)</p>
        <p>Price:<strong>USD 5.45</strong></p>
    </div>
);
export default Order;