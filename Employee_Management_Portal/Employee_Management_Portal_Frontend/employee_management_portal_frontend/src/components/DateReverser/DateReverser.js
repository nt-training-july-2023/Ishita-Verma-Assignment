import React from 'react';

const DateReverser = ({ date }) => {
  const reverseDate = (date) => {
    if (date && date.includes('-')) {
      const [year, month, day] = date.split('-');
      return `${day}-${month}-${year}`;
    }
    return 'Invalid Date';
  };

  return <span>{reverseDate(date)}</span>;
};

export default DateReverser;
