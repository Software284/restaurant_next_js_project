import classes from './index.module.scss';
import Button from '../../components/UI/Button/Button';
import Input from '../../components/UI/Input/Input';
import Spinner from '../../components/UI/Spinner/Spinner';
import {useState} from 'react';
const AdminPage = (props:any) => {

    const [loading,setLoading] =useState<boolean>(false);
    const [ProductForm, setProductForm]: any = useState({
      name: {
        elementType: "input",
        elementConfig: {
          type: "text",
          placeholder: "Your Name",
        },
        value: "",
      },
      image: {
        elementType: "input",
        elementConfig: {
          type: "file",
          placeholder: "Your Image",
        },
        value: "",
      },
      ratings: {
        elementType: "input",
        elementConfig: {
          type: "number",
          placeholder: "Your ratings",
        },
        value: "",
      },
      price: {
        elementType: "input",
        elementConfig: {
          type: "number",
          placeholder: "Your Price",
        },
        value: "",
      }
    });

    const formElementsArray = [];
    for (let ke in ProductForm) {
    formElementsArray.push({
        id: ke,
        config: ProductForm[ke],
    });
 }

 const AddProductHandler = (event:any) => {

 }

 function inputChangedHandler(event: any, inputIdentifier: any) {
    console.log(event.target.value);
   const updatedForm = {
     ...ProductForm,
   };
   const updatedFormElement = {
     ...updatedForm[inputIdentifier],
   };

   updatedFormElement.value = event.target.value;
   updatedForm[inputIdentifier] = updatedFormElement;
   setProductForm(updatedForm);
 }

 let form = (
   <form onSubmit={AddProductHandler}>
     {formElementsArray.map((formElement, index) => (
       <Input
         changed={(event) => inputChangedHandler(event, formElement.id)}
         key={formElement.id}
         elementType={formElement.config.elementType}
         elementConfig={formElement.config.elementConfig}
         value={formElement.config.value} invalid={false} shouldValidate={false} touched={false}       />
     ))}

     <Button btnType="Success" clicked={props.click}>
       Order
     </Button>
   </form>
 );
 if (loading) {
   form = <Spinner />;
 }
    return (
      <div className={classes.ContactData}>
        <h4>Enter Your Product Data</h4>
        {form}
      </div>
    );
}
export default AdminPage;;