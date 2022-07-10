import { url } from 'inspector';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FiX } from 'react-icons/fi';
import Games from '../Games';
import api from '../../../../services/api';
import './Game.css'
import Players from '../../../ShoeAndPlayers/Players/Players'
import ShoeAndPlayers from '../../../ShoeAndPlayers/ShoeAndPlayers';


interface GameProps {
  id: number;
  name: string;
}


function displayGame2(id: number) {
  const shoeAndPlayerWrapper = document.getElementById('shoeAndPlayerWrapper') as HTMLDivElement | null;

  api.get('games/'+ id).then(response => {
    if(shoeAndPlayerWrapper != null) {
      shoeAndPlayerWrapper.innerHTML = parseGameResponse(response.data);
    } else {
      console.log("something happened...");
    }
  })
}

function parseGameResponse(incomingResponse: string) {
  console.log(incomingResponse);
  return incomingResponse;
}

const currentPlayer = {
  id: 3,
  name: "Guilherme",
  points: 0,
  gameId: 2
}

const Game: React.FC<GameProps> = (props) => {
  return (
      <div className='game'>
        <Link to={'/games/'+ props.id} onClick={() => {
          Players();
        }}>
          <span className='game-title'>ID {props.id} - {props.name}</span></Link>
          <Link className='deleteIcon' onClick={() => {
            deleteGame(props.id);
            ShoeAndPlayers();
          }} to={'/games'}>
            <FiX className='delete-icon'/>
            </Link>
      </div>
  );
}

async function deleteGame(id: number) {
  const res = await api.delete('games/'+ id);
}

async function loadGame(id: number) {
  const res = await api.get('games/' + id);
}

export default Game;