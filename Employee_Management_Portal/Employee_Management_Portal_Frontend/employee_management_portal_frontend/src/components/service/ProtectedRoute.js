import React from "react";
import { Route, Navigate } from "react-router-dom";
import { useAuth } from "./AuthenticationContext";

const ProtectedRoute = ({ path, element }) => {
  const { isLoggedIn } = useAuth();

  if (!isLoggedIn) {
    return <Navigate to="/login" />;
  }

  return <Route path={path} element={element} />;
};

export default ProtectedRoute;
