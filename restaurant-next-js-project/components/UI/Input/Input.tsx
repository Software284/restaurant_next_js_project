import React from 'react';

import classes from './Input.module.css';
interface Props {
    label?:string;
    elementType:string;
    elementConfig:any;
    value:string;
    invalid:boolean;
    shouldValidate:boolean;
    touched:boolean;
    changed: (e:any) => void;
}
const Input : React.FC<Props> = (props) => {

    let inputElement:any = null;
    const inputClasses = [classes.InputElement];

    if(props.invalid && props.shouldValidate && props.touched){
      inputClasses.push(classes.Invalid);
    }

    switch(props.elementType){
        case 'input':
            inputElement = (
              <input
                {...props.elementConfig}
                className={inputClasses.join(' ')}
                onChange={props.changed}
              />
            );
            break;
        case 'textarea':
            inputElement = (
              <textarea
                {...props.elementConfig}
                className={inputClasses.join(' ')}
                onChange={props.changed}
              />
            );
            break;
        case 'select':
            inputElement = (
              <select
                className={inputClasses.join(' ')}
                value={props.value}
                onChange={props.changed}
              >
                {props.elementConfig.options.map((option: any) => (
                  <option value={option.value} key={option.value}>
                    {option.displayValue}
                  </option>
                ))}
              </select>
            );
            break;
        default:
            inputElement = (
              <input
                {...props.elementConfig}
                className={inputClasses.join(' ')}
                onChange={props.changed}
              />
            );
    }
    return (
        <div className={classes.Input}>
            <label className={classes.Label}>{props.label}</label>
            {inputElement}
        </div>
    );

};

export default Input;