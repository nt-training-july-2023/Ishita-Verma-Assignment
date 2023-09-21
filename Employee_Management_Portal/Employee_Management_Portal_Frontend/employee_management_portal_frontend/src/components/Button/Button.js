import React from 'react';
import './button.css';

const Button = ({ onClick, text }) => {
  return (
    <button onClick={onClick} className="custom-button">
      {text}
    </button>
  );
};

export default Button;
