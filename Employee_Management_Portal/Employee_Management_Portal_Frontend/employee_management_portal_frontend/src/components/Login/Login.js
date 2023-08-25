import { React, useState } from "react";
import "./login.scss";
import AdminService from "../service/AdminService";
import { Button, Form, Dropdown, DropdownButton } from "react-bootstrap";
import login_img from "../../Assests/Images/login_img.png";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();
    const formData = {
      email,
      password,
    };

    AdminService.loginAdmin(formData)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="login_section">
        <div className="login_heading">Employee Management Portal</div>

        <div className="login_form">
          <Form>
            <Form.Group className="login_form_field" controlId="formBasicEmail">
              <Form.Control
                type="email"
                placeholder="Enter email"
                className="login_input_field"
                autoComplete="off"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </Form.Group>

            <Form.Group
              className="login_form_field"
              controlId="formBasicPassword"
            >
              <Form.Control
                type="password"
                placeholder="Password"
                className="login_input_field"
                autoComplete="off"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Form.Group>

            <Form.Group
              className="login_form_field"
              controlId="formBasicPassword"
            >
              <Form.Label>Not a user ? Register</Form.Label>
            </Form.Group>
            <Button variant="primary" type="submit" className="btn btn-primary" onClick={onSubmit}>
              Submit
            </Button>
          </Form>
        </div>
        <div>
          <img src={login_img} className="login_img" alt="Login" />
        </div>
      </div>
    </div>
  );
};

export default Login;
