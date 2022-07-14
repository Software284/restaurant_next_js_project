import React from 'react';
import classes from './Button.module.css';

interface ButtonProps{
    btnType: string;
    disabled?:boolean;
    clicked: (event:any) => void;
}

const button : React.FC<ButtonProps> = (props) =>
{
    return (
      <button
        disabled={props.disabled}
        className={[classes.Button, classes[props.btnType]].join(" ")}
        onClick={(event) => props.clicked(event)}
      >
        {props.children}
      </button>
    );
}
    

export default button;