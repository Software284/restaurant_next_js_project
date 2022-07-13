import React from 'react';

import classes from './Input.module.css';
interface Props {
    label?:string;
    elementType:string;
    elementConfig:any;
    value:string;
    changed: (e:any) => void;
}
const Input : React.FC<Props> = (props) => {

    let inputElement:any = null;

    switch(props.elementType){
        case 'input':
            inputElement = <input {...props.elementConfig} className={classes.InputElement} onChange={props.changed} />;
            break;
        case 'textarea':
            inputElement = (
              <textarea
                {...props.elementConfig}
                className={classes.InputElement}
                onChange={props.changed}
              />
            );
            break;
        case 'select':
            inputElement = (
              <select
                className={classes.InputElement}
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
                className={classes.InputElement}
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