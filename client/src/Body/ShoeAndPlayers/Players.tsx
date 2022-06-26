import React, { useEffect, useState } from 'react';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import Player from './Player';
import { FiPlusCircle } from 'react-icons/fi';

interface PlayersProps {
    gameId: number;
}

interface Player {
    id: number;
    name: string;
    points: number;
}

const Players: React.FC<PlayersProps> = (props) => {
    const[playersData, setPlayers] = useState<Player[]>([]);

    useEffect(() => {
        api.get('games/' + props.gameId).then(response => {
            console.log(response.data.players);
            setPlayers(response.data.players);
        })
    },
    []
    )
        
    return (
        <div>
            <div className='players'>
            <h3>Players: </h3>
            <ul className="players-grid">
                {playersData.map(player => (
                    <Player id={player.id} name={player.name} points={player.points} />
                ))}
            </ul>
            <div className="field">
                <input 
                    type="text" 
                    name="playerName" 
                    id="playerName" 
                    placeholder="New Player"
                />
                <Link onClick={() => 
                    {
                    const input = document.getElementById('playerName') as HTMLInputElement | null;
                    const playerNameValue = input?.value || "New Player";
                    newPlayer(playerNameValue, props.gameId);
                    Players(props);
                    }
                    } to="/players"> &nbsp;&nbsp;
                <FiPlusCircle />
                </Link>
                </div>
            </div>
        </div>
    );
}

function newPlayer(name: string, gameId: number) {
    if(name == '') name = 'New Player';
  
    api.post('players',
    {
      name: name,
      game_id: gameId,
      points: 0
    }).then(function (error) {
      console.log(error);
    })  
}

export default Players