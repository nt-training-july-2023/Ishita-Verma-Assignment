import React from 'react';
// import './/popup.css';
import SubmitImg from '../../Assests/Images/Submit_img.png'

const SubmitPopup = ({ description, onClose, onConfirm }) => {
  return (
    <div className="project-popup">
      <div className="project-popup-content">
       
        <img src={SubmitImg}/>
        <p className='popup-description'>{description}</p>
     <div>  
        <button className="close-button close_unaasign" onClick={onClose}>
          Close
        </button>
        </div>
      </div>
    </div>
  );
};

export default SubmitPopup;
