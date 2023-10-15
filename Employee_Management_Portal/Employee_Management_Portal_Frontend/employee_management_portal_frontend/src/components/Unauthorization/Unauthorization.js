import React from 'react'
import errorGif from '../../Assests/Images/errorsGif.gif'
import './unauthorization.css'

const UnAuthorization = () => {
  
  return (

    <div className='unauthorized'>
      <h1 className='error_heading'>
         UnAuthorized !! Access Denied
        <span className='error_symbol'>&#10811;</span> </h1>
        
        <a href="/"> &#x2190; Back to homepage.</a>
        
      <img src={errorGif} className='error_gif'/>
    </div>
  )
}

export default UnAuthorization