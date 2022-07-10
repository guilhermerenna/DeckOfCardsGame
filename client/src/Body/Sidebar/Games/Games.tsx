import React, { useEffect, useState } from 'react';
import Game from './Game/Game';
import { FiPlusCircle } from 'react-icons/fi';
import { Link } from 'react-router-dom';
import api from '../../../services/api';
import './Games.css'

function newGame(name: string) {
  if(name == '') name = 'New Game';

  api.post('games',
  {
    name: name
  }).then(function (error) {
    console.log(error);
  })  
}

// array, object: manually inform var type
interface Game {
  id: number;
  name: string;
}

const Games = () => {
  const[games, setGames] = useState<Game[]>([]);

  useEffect(() => {
    api.get('games').then(response => {
      setGames(response.data);
    })
  }, 
  [] //no parameter passed. This means the method above will be called only once
  );

  const input = document.getElementById('gameName') as HTMLInputElement | null;

  return (
      <div className='games-wrapper'>
        <div className="games-title">
          <h3>Games: </h3>
        </div>
        <ul className='games-grid'>
          {games.map(game => (
            <li key={game.id}>
              <Game id={game.id} name={game.name} />
            </li>
          ))}
        </ul>
        <div className="field">
          <input 
            type="text" 
            name="gameName" 
            id="gameName" 
            placeholder="New Game"
          />
        <Link onClick={() => 
        {
          const input = document.getElementById('gameName') as HTMLInputElement | null;
          const gameNameValue = input?.value || "New Game";
          newGame(gameNameValue);
          Games();
        }
        } to={{}}> &nbsp;&nbsp;
          <FiPlusCircle />
        </Link>
        </div>
      </div>
  );
}

export default Games;