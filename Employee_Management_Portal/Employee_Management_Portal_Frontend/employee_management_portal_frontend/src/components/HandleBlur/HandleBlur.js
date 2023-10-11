
export const validateName = (inputValue, setNameError) => {
 if(inputValue===""){
  setNameError("Name is required.")
 }else{
    const alphabeticRegex = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;
    if (!alphabeticRegex.test(inputValue)) {
      setNameError("Name must contain alphabetic characters only.");
    } else {
      setNameError("");
    }
  }
}


export const validateEmail = (inputValue, setEmailError) => {
  if(inputValue===""){
    setEmailError("Email can't be empty.")
  }
  else{
    const emailRegex = /^ankita\.sharma@nucleusteq\.com$/;
    if (!emailRegex.test(inputValue)) {
      setEmailError("Only admin can register.");
    } else {
      setEmailError("");
    }
  }

}

export const validateEmpId = (inputValue, setEmpIdError) => {
 if(inputValue===""){
  setEmpIdError("Employee Id can't be empty.")
 }else{
    const empIdRegex = /^[Nn][1-9][0-9]{3}$/;
    if (!empIdRegex.test(inputValue)) {
      setEmpIdError("Employee ID should be in pattern NXXXX.");
    } else {
      setEmpIdError("");
    }
  }
}


export const validateDob = (dob, setDobError) => {
  if(dob===""){
    setDobError("Date of Birth can't be empty.")
  }
  else{
  const today = new Date();
  const minDate = new Date(today.getFullYear() - 18, today.getMonth(), today.getDate());
    const dobDate = new Date(dob);
    if (isNaN(dobDate)) {
      setDobError("Invalid date format.");
    } else if (dobDate > today) {
      setDobError("Date of Birth cannot be in the future.");
    } else if (dobDate > minDate) {
      setDobError("You must be at least 18 years old.");
    } else {
      setDobError("");
    }
  }
}

export const validateDoj = (doj, setDojError) => {
  if(doj===""){
    setDojError("Date of Joining can't be empty.")
  }
  else{
  const today = new Date();
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    const dojDate = new Date(doj);
    if (!dateRegex.test(doj)) {
      setDojError("Date should have a pattern like DD-MM-YY.");
    } else if (isNaN(dojDate) || dojDate > today) {
      setDojError("Date of Joining cannot be in the future.");
    } else {
      setDojError("");
    }
  }
}

 export const validateDesignation = (inputValue,setDesignationError) => {
    if (inputValue === "") {
      setDesignationError("Designation cannot be empty.");
    }
    else{
      setDesignationError("")
    }
  };

export const validateLocation = (inputValue,setLocationError) => {
    if (inputValue === "") {
      setLocationError("Location cannot be empty.");
    }
    else{
      setLocationError("")
    }
  };

export const validateContactNumber = (
  inputValue,
  setContactNumber,
  setContactNumberError
) => {
  if(inputValue===""){
    setContactNumberError("Contact Number can't be empty.");
  }
  else{
  const cleanedContactNumber = inputValue.replace(/[^0-9]/g, "");
  if (!/^\d{10}$/.test(cleanedContactNumber)) {
    setContactNumberError("Contact no should have 10 digits only.");
  } else {
    setContactNumber(cleanedContactNumber);
    setContactNumberError("");
  }
}
}


export const validatePassword = (inputValue, setPasswordError) => {
  if(inputValue===""){
    setPasswordError("Password can't be empty.")
  }else{
    const passwordRegex =
    /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~]).{8,}$/;
  if (!passwordRegex.test(inputValue)) {
    setPasswordError("Use 8 digits uppercase lowercase special character.");
  } else {
    setPasswordError("");
  }
}
}


export const validateConfirmPassword = (
  inputValue,
  password,
  setConfirmPasswordError
) => {
  if(inputValue===""){
    setConfirmPasswordError("Confirm Password can't be empty.")
  }
  else{
  { if (inputValue !== password) {
    setConfirmPasswordError("Password and confirm password do not match.");
  } else {
    setConfirmPasswordError("");
  }
}}
  }

export const validateEmployeeEmail =  (inputValue, setEmailError) => {
  if(inputValue===""){
    setEmailError("Email can't be empty.")
  }
  else{
    const emailRegex = /@nucleusteq\.com$/;
    if (!emailRegex.test(inputValue)) {
      setEmailError("Email must be a company email.");
    } else {
      setEmailError("");
    }
  }

}
export const validateRole = (inputValue,setRoleError)=>{
  if(inputValue===""){
    setRoleError("Role can't be empty.")
  }
  else{
    setRoleError("");
  }
}

export const validateSkills =  (inputValue,setSkillsError)=>{
  if(inputValue.length===0){
    setSkillsError("Skills can't be empty.")
  }
  else{
    setSkillsError("");
  }
}
export const validateManagerId = (inputValue, setManagerIdError) => {
  if (inputValue.trim() === "") {
    setManagerIdError("Manager ID is required.");
  } else {
    setManagerIdError("");
  }
};

export const validateStartDate = (inputValue, setStartDateError) => {
  if(inputValue === ""){
    setStartDateError("Start Date can't be empty.")
  } else {
    setStartDateError("");
  }
};

export const validateDescription = (inputValue, setDescriptionError) => {
  if (inputValue.trim() === "") {
    setDescriptionError("Description is required.");
  } else {
    setDescriptionError("");
  }
};

export const validateSelectProject = (inputValue, setProjectError) => {
  if (inputValue === 0) {
    setProjectError("Please select a project.");
  } else {
    setProjectError("");
  }
}

export const validateLoginPassword = (inputValue, setPasswordError) => {
  if (inputValue === "") {
    setPasswordError("Password can't be empty.");
  } else {
    setPasswordError("");
  }
}