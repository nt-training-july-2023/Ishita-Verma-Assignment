import React from 'react';
import './popup.css';

const Popup = ({ description, onClose, onConfirm }) => {
  return (
    <div className="project-popup">
      <div className="project-popup-content">
       
        <p className='popup-description'>{description}</p>
     <div>   {onConfirm && ( 
          <button className="confirm-button confirm_unassign" onClick={onConfirm}>
            Confirm
          </button>
        )}
        <button className="close-button close_unaasign" onClick={onClose}>
          Close
        </button>
        </div>
      </div>
    </div>
  );
};

export default Popup;
