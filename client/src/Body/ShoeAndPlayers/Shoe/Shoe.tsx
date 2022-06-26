import React from 'react';
import './Shoe.css';
import { FiShuffle } from 'react-icons/fi';
import SuitListing from './SuitListing';
import SuitStatisticsList from './SuitStatisticsList';

function Shoe() {
  
  return (
      <div className='shoe'>
        <div className='shoe-summary-grid'>
          <div className='shoe-grid-entry'>Game Shoe <FiShuffle /></div>
          <div>Cards left in the game:</div>
          <SuitStatisticsList gameId={2}/>
        </div>
        <div className="shoe-card-list">
          <SuitListing gameId={2} suit="h" />
          <SuitListing gameId={2} suit="s" />
          <SuitListing gameId={2} suit="c" />
          <SuitListing gameId={2} suit="d" />
        </div>
      </div>
  );
}

export default Shoe