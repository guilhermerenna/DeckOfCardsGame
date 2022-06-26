import React from 'react';
import './Body.css';
import ShoeAndPlayersEmpty from './ShoeAndPlayers/ShoeAndPlayersEmpty';
import Sidebar from './Sidebar/Sidebar';
import {
  BrowserRouter as Router,
  Route
} from "react-router-dom";
import ShoeAndPlayers from './ShoeAndPlayers/ShoeAndPlayers';

function Body() {
  return (
      <div className='body'>
          <Sidebar />
          
          <div className="shoeAndPlayerWrapper">
          <ShoeAndPlayers />
          </div>
      </div>
  );
}

export default Body;