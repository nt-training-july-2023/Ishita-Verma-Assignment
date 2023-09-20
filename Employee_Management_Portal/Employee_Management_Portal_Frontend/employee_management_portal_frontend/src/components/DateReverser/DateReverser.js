import React from 'react';

const DateReverser = ({ date }) => {
  // Function to reverse a date (assuming date is in 'YYYY-MM-DD' format)
  const reverseDate = (date) => {
    if (date && date.includes('-')) {
      const [year, month, day] = date.split('-');
      return `${day}-${month}-${year}`;
    }
    // Return a message for invalid or undefined dates
    return 'Invalid Date';
  };

  return <span>{reverseDate(date)}</span>;
};

export default DateReverser;
