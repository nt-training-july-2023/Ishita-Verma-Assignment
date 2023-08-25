import { React, useState } from "react";
import "./registration.scss";
import AdminService from "../service/AdminService";
import reg_plant_img from "../../Assests/Images/reg_plant_img.png";
import reg_side_img from "../../Assests/Images/reg_side_img.png";
import { Button, Form } from "react-bootstrap";

const Registration = () => {
  const [adminId, setAdminId] = useState("");
  const [empId, setEmpId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmailId] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

//validation
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();

    let isValid = true;
    if (!email.endsWith("@nucleusteq.com")) {
      setEmailError("Email must be a company email (@nucleusteq.com)");
      isValid = false;
    } else {
      setEmailError("");
    }

      // Employee ID validation
      if (!/^[Nn]\d{4}$/.test(empId)) {
        setEmpIdError("Employee ID should be in pattern NXXXX");
        isValid = false;
      } else {
        setEmpIdError("");
      }
  
      // Date of Birth and Date of Joining validation
      if (!/\d{2}\/\d{2}\/\d{4}/.test(dob) || !/\d{2}\/\d{2}\/\d{4}/.test(doj)) {
        setDobError("DOB and DOJ should have a pattern like DD/MM/YYYY");
        setDojError("DOB and DOJ should have a pattern like DD/MM/YYYY");
        isValid = false;
      } else {
        setDobError("");
        setDojError("");
      }
  
      // Contact Number validation
      if (!/^\d{10}$/.test(contactNumber)) {
        setContactNumberError("Contact no should have 10 digits only");
        isValid = false;
      } else {
        setContactNumberError("");
      }
  
      // Password validation
      if (password !== confirmPassword) {
        setPasswordError("Password and confirm password do not match");
        isValid = false;
      } else {
        setPasswordError("");
        setConfirmPasswordError("");
      }


    const formData = {
      adminId,
      empId,
      name,
      email,
      dob,
      doj,
      location,
      designation,
      contactNumber,
      password,
      confirmPassword,
    };
    AdminService.registerAdmin(formData)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="reg_heading">
        <div>
          Employee Management Portal
          <img src={reg_plant_img} className="reg_plant_img" />
        </div>
      </div>
      <div className="reg_page">
        <div className="reg_form">
          <Form>
            <Form.Group controlId="formBasicEmail" className=" reg_form_field" >
              {/* <Form.Label>Email address</Form.Label> */}
              <Form.Control
                type="text"
                placeholder="Name"
                className="reg_form_input"
                value={name}
                onChange={(e) => setName(e.target.value)}
                autoComplete="off"
              />
            </Form.Group>
            

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="email"
                placeholder="Email :"
                className="reg_form_input"
                value={email}
                onChange={(e) => setEmailId(e.target.value)}
                autoComplete="off"
              />
            </Form.Group>
            {emailError && <div className="error-message">{emailError}</div>}


            <Form.Group className=" reg_form_field" controlId="formBasicEmail">
              <Form.Control
                type="text"
                placeholder="Employee ID :"
                className="reg_form_input"
                value={empId}
                onChange={(e) => setEmpId(e.target.value)}
                autoComplete="off"
              />
            </Form.Group>
            {empIdError && <div className="error-message">{empIdError}</div>}

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="date"
                placeholder="DOB :"
                className="reg_form_input"
                value={dob}
                onChange={(e) => setDob(e.target.value)}
              />
            </Form.Group>
            {dobError && <div className="error-message">{dobError}</div>}

            <Form.Group className=" reg_form_field" controlId="formBasicEmail">
              <Form.Control
                type="date"
                placeholder="DOJ :"
                className="reg_form_input"
                value={doj}
                onChange={(e) => setDoj(e.target.value)}
              />
            </Form.Group>
            {dojError && <div className="error-message">{dojError}</div>}

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="text"
                placeholder="Location :"
                className="reg_form_input"
                value={location}
                onChange={(e) => setLocation(e.target.value)}
              />
            </Form.Group>
            

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
              
            >
              <Form.Control
                type="text"
                placeholder="Designation :"
                className="reg_form_input"
                value={designation}
                onChange={(e) => setDesignation(e.target.value)}
              />
            </Form.Group>

            <Form.Group className=" reg_form_field" controlId="formBasicEmail">
              <Form.Control
                type="number"
                placeholder="Contact No :"
                className="reg_form_input"
                value={contactNumber}
                onChange={(e) => setContactNumber(e.target.value)}
              />
            </Form.Group>
            {contactNumberError && <div className="error-message">{contactNumberError}</div>}

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="password"
                placeholder="Password :"
                className="reg_form_input"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Form.Group>
            {passwordError && <div className="error-message">{passwordError}</div>}

            <Form.Group
              className=" reg_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="password"
                placeholder="Confirm Password :"
                className="reg_form_input"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
              />
            </Form.Group>
            {confirmPasswordError && <div className="error-message">{confirmPasswordError}</div>}

            <Button
              onClick={onSubmit}
              className="btn btn-primary"
              type="submit"
            >
              Submit
            </Button>
          </Form>
        </div>
        <div>
          {/* <img src={reg_img} alt="Registration Image" className='reg_img' /> */}
          <img src={reg_side_img} className="reg_side_img" />
        </div>
      </div>
    </div>
  );
};

export default Registration;
