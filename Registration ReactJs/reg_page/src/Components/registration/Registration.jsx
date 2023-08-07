import React from "react";
import "./registration.scss";
import { Button, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";


const Registration = () => {
  return (
    <div className="reg_background">
      <div className="reg_card">
        <div className="reg_card_heading">Registration</div>

        <div className="reg_card_form">
          <Form className="reg_card_form_field">
            <Form.Group >
              <Form.Label>Full Name</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Name"  className="reg_input"/>
            </Form.Group>

            <Form.Group >
              <Form.Label>Email</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Email " className="reg_input" />
            </Form.Group>

            <Form.Group >
              <Form.Label>Username</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Username "  className="reg_input"/>
            </Form.Group>

            <Form.Group >
              <Form.Label>Phone Number</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Phone Number " className="reg_input"/>
            </Form.Group>

            <Form.Group >
              <Form.Label>Password</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Password " className="reg_input"/>
            </Form.Group>

            <Form.Group >
              <Form.Label>Confirm Password</Form.Label>
              <Form.Control type="email" placeholder="Enter Your Confirm Password" className="reg_input"/>
            </Form.Group>
          </Form>
        </div>

        <div className="reg_card_gender_heading">Gender</div>
        <div className="reg_card_gender">
          {/* <div className="gender-label">Gender</div> */}
          <div className="gender-options">
            
            <Form.Check type="radio" label="Male" name="gender" id="male" />
            
            <Form.Check type="radio" label="Female" name="gender" id="female" />
            
            <Form.Check
              type="radio"
              label="Prefer not to say"
              name="gender"
              id="other"
            />
          </div>
        </div>
        <div className="reg_button"> Register</div>
      </div>
    </div>
  );
};

export default Registration;
