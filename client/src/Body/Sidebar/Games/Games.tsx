import React, { useEffect, useState } from 'react';
import Game from './Game/Game';
import { FiPlusCircle } from 'react-icons/fi';
import { Link } from 'react-router-dom';
import api from '../../../services/api';

function newGame(gameName: string) {
  if(gameName == '') gameName = 'New Game';

  api.post('games',
  {
    gameName: gameName
  }).then(function (error) {
    console.log(error);
  })

  Games();
  
}

// array, object: manually inform var type
interface Game {
  id: number;
  gameName: string;
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

  return (
      <div className='games'>
        <div className="games-title">
          Games: 
        <Link onClick={() => 
        {
          const input = document.getElementById('gameName') as HTMLInputElement | null;
          const gameNameValue = input?.value || "New Game";
          newGame(gameNameValue)
        }
        } to="/games">
          <FiPlusCircle />
        </Link>
        </div>
        <ul className='games-grid'>
          {games.map(game => (
            <li key={game.id}>
              <Game id={game.id} gameName={game.gameName} />
            </li>
          ))}
        </ul>
        <div className="field">
          <input 
            type="text" 
            name="gameName" 
            id="gameName" 
          />
        </div>
      </div>
  );
}

export default Games;