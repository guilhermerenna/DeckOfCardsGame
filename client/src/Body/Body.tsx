import React from 'react';
import './Body.css';
import Sidebar from './Sidebar/Sidebar';

function Body() {
  return (
      <div className='body'>
        <Sidebar /><div className='shoeAndPlayers'>Shoe and Players</div>
      </div>
  );
}

export default Body;