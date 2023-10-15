import React from 'react';
import './requestPopup.css'

const RequestStatusPopup = ({ message, onClose,img }) => {
  return (
    <div className="project-popup">
      <div className="project-popup-content">
        <img src={img} className="request_imgs"/>
        <p className='popup-description'>{message}</p>
        <button className="close-button close_unaasign" onClick={onClose}>
          Close
        </button>
      </div>
    </div>
  );
};

export default RequestStatusPopup;
