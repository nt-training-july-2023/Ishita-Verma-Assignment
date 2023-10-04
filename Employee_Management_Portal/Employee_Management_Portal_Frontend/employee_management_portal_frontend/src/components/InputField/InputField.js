import React from "react";

const InputField = ({
  type,
  placeholder,
  value,
  onChange,
  onBlur,
  className,
}) => {
  return (
   <>
      <input
        type={type}
        placeholder={placeholder}
        className={className}
        value={value}
        onChange={onChange}
        onBlur={onBlur}
        
      />
   </>
  );
};

export default InputField;
