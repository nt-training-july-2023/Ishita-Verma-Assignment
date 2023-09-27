import React from 'react'

export const validateName = (inputValue, setNameError) => {
    const alphabeticRegex = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;
    if (!alphabeticRegex.test(inputValue)) {
      setNameError("Name must contain alphabetic characters only");
    } else {
      setNameError("");
    }
  };
  
  export const validateEmail = (inputValue, setEmailError) => {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@nucleusteq\.com$/;
    if (!emailRegex.test(inputValue)) {
      setEmailError("Email must be a company email (@nucleusteq.com)");
    } else {
      setEmailError("");
    }
  };
  
  export const validateEmpId = (inputValue, setEmpIdError) => {
    const empIdRegex = /^[Nn]\d{4}$/;
    if (!empIdRegex.test(inputValue)) {
      setEmpIdError("Employee ID should be in pattern NXXXX");
    } else {
      setEmpIdError("");
    }
  };
  
  export const validateDob = (inputValue, setDobError) => {
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    if (!dateRegex.test(inputValue)) {
      setDobError("Date should have a pattern like DD-MM-YY");
    } else {
      setDobError("");
    }
  };
  
  export const validateDoj = (inputValue, setDojError) => {
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    if (!dateRegex.test(inputValue)) {
      setDojError("Date should have a pattern like DD-MM-YY");
    } else {
      setDojError("");
    }
  };
  
  export const validateContactNumber = (inputValue, setContactNumber, setContactNumberError) => {
    const cleanedContactNumber = inputValue.replace(/[^0-9]/g, "");
    if (!/^\d{10}$/.test(cleanedContactNumber)) {
      setContactNumberError("Contact no should have 10 digits only");
    } else {
      setContactNumber(cleanedContactNumber);
      setContactNumberError("");
    }
  };
  
  export const validatePassword = (inputValue, setPasswordError) => {
    const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~]).{8,}$/;
    if (!passwordRegex.test(inputValue)) {
      setPasswordError("Use 8 digits uppercase lowercase special character");
    } else {
      setPasswordError("");
    }
  };
  
  export const validateConfirmPassword = (inputValue, password, setConfirmPasswordError) => {
    if (inputValue !== password) {
      setConfirmPasswordError("Password and confirm password do not match");
    } else {
      setConfirmPasswordError("");
    }
  };
  



