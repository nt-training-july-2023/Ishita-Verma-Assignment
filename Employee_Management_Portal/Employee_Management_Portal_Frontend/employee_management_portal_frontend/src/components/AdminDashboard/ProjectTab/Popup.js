import React from 'react'
import './popup.css';

const Popup = ({ description, onClose }) => {
  return (
    <div>
       <div className="project-popup">
      <div className="project-popup-content">
        <p className='popup-description'>{description}</p>
         <button className="close-button" onClick={onClose}>
          Close
          </button>
      </div>
    </div>
    </div>
  )
}

export default Popup
