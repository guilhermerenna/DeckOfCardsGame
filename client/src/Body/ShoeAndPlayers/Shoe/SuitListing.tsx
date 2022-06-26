import React from 'react';
import './Shoe.css';

interface SuitListingProps {
    
}

function SuitListing() {
  return (
      <div className='shoe-listing'>
        <div className="shoe-card-list-red">RedBlock</div>
        <div className="shoe-card-list-black">BlackBlock</div>
        <div className="shoe-card-list-black">BlackBlock</div>
        <div className="shoe-card-list-red">RedBlock</div>
      </div>
  );
}

export default SuitListing