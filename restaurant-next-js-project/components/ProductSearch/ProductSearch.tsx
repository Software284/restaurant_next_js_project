import {useState} from 'react';
import classes from './ProductSearch.module.css';
import Input from '../UI/Input/Input';
import Button from '../UI/Button/Button';
import Router from 'next/router';
import { NULL } from 'sass';
function ProductSearch(){

    const [productSearch, setProductSearch]: any = useState({
      type: {
        elementType: "select",
        elementConfig: {
          options: [
            { value: "Food", displayValue: "Food" },
            { value: "Drinks", displayValue: "Drinks" },
          ],
        },
        value: "Food",
        validation: {},
        valid: true,
      },
      price: {
        elementType: "select",
        elementConfig: {
          options: [
            { value: "Less Than 100", displayValue: "Less Than 100" },
            { value: "Less Than 200", displayValue: "Less Than 200" },
            { value: "Less Than 300", displayValue: "Less Than 300" },
            { value: "Less Than 400", displayValue: "Less Than 400" },
            { value: "Less Than 500", displayValue: "Less Than 500" },
          ],
        },
        value: "Less Than 100",
        validation: {},
        valid: true,
      },
    });

    const filterProducts = (event:any) => {
         event.preventDefault();
         Router.push(`/${productSearch.type.value}/${productSearch.price.value}`)
    }

    const formElementsArray:any = [];
    for (let ke in productSearch) {
      formElementsArray.push({
        id: ke,
        config: productSearch[ke],
      });
    }

    function inputChangedHandler(event: any, inputIdentifier: any) {
        console.log("Inside inputChangedHandler="+inputIdentifier)
      const updatedForm = {
        ...productSearch,
      };
      const updatedFormElement = {
        ...updatedForm[inputIdentifier],
      };

      updatedFormElement.value = event.target.value;
      updatedForm[inputIdentifier] = updatedFormElement;
      console.log(productSearch);
      setProductSearch(updatedForm);
      
    }


    
    return (
      <form className={classes.form} onSubmit={filterProducts}>
        <div className={classes.controls}>
          {formElementsArray.map((formElement:any, index:any) => {
            return (
              <div className={classes.control} key={index}>
                <Input
                  changed={(event: any) =>
                    inputChangedHandler(event, formElement.id)
                  }
                  key={formElement.id}
                  elementType={formElement.config.elementType}
                  elementConfig={formElement.config.elementConfig}
                  value={formElement.config.value}
                  invalid={false}
                  shouldValidate={false}
                  touched={false}
                />
              </div>
            );
          })}
          <button>
            Find Product
          </button>
        </div>
      </form>
    );
}
export default ProductSearch;