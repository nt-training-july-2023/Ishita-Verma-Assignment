import React from 'react';
import './popup.css';

const Popup = ({ description, onClose, onConfirm }) => {
  return (
    <div className="project-popup">
      <div className="project-popup-content">
        <button className="close-button" onClick={onClose}>
          X
        </button>
        <p className='popup-description'>{description}</p>
        {onConfirm && ( 
          <button className="confirm-button" onClick={onConfirm}>
            Yes
          </button>
        )}
      </div>
    </div>
  );
};

export default Popup;
