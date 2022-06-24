import React from 'react';
import Game from './Game/Game';


function Games() {
  return (
      <div className='games'>
        <h3>Games:</h3>
        <Game />
        <Game />
        <Game />
      </div>
  );
}

export default Games;