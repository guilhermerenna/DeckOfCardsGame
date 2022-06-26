import React from 'react';
import './ShoeAndPlayers.css';
import Shoe from './Shoe/Shoe';
import Players from './Players/Players';

function ShoeAndPlayers() {
  
  return (
      <div>
        <div className='shoeAndPlayers'>
          <Shoe />
          <Players gameId={2} />
        </div>
      </div>
  );
}

export default ShoeAndPlayers;