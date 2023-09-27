import React from 'react';
import './button.css';

const Button = ({ onClick, text, className }) => {
  return (
    
    <button onClick={onClick}  className={`custom-button ${className}`}>
      {text}
    </button>
 
  );
};

export default Button;
