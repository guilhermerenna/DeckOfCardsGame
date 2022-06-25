import React from 'react';
import './Body.css';
import ShoeAndPlayersEmpty from './ShoeAndPlayers/ShoeAndPlayersEmpty';
import Sidebar from './Sidebar/Sidebar';

function Body() {
  return (
      <div className='body'>
        <Sidebar />
        <div className="shoeAndPlayerWrapper"><ShoeAndPlayersEmpty /></div>
      </div>
  );
}

export default Body;