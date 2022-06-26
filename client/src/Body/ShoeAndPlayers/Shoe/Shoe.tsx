import React from 'react';
import './Shoe.css';
import { FiShuffle } from 'react-icons/fi';
import SuitListing from './SuitListing';

function Shoe() {
  
  return (
      <div className='shoe'>
        <div className='shoe-summary-grid'>
          <div className='shoe-grid-entry'>Game Shoe <FiShuffle /></div>
          <div className="shoe-grid-entry">100 cards undealt</div>
          <ul className="shoe-grid-entry">
            <li className="shoe-grid-entry">26 spades</li>
            <li className="shoe-grid-entry">25 hearts</li>
            <li className="shoe-grid-entry">24 diamonds</li>
            <li className="shoe-grid-entry">25 clubs</li>
          </ul>
        </div>
        <div className="shoe-card-list">
          <SuitListing />
          <SuitListing />
          <SuitListing />
          <SuitListing />
        </div>
      </div>
  );
}

export default Shoe