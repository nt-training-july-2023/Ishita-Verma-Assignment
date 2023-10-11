import React from 'react';
import './button.css';

const Button = ({ onClick, text, className,type }) => {
  return (
    
    <button onClick={onClick}  className={`custom-button ${className}`} type={type}>
      {text}
    </button>
     
  );
};

export default Button;
