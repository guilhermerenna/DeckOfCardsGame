import React, { useEffect, useState } from 'react';
import api from '../../../services/api';
import { Link, Route, Routes, useParams } from 'react-router-dom';
import Player from './Player';
import { FiPlusCircle } from 'react-icons/fi';
import PlayerHand from './Cards/PlayerHand';
import './Players.css'

interface Player {
    id: number;
    name: string;
    points: number;
    gameId: number;
}

const Players = () => {
    const{ gameId, playerId } = useParams();
    const gameIdNumber = parseInt(gameId || '0');
    console.log(window.location.pathname + ' -- Game ' + gameId + ' , player ' + playerId);

    const[playersData, setPlayers] = useState<Player[]>([]);

    useEffect(() => {
        if(gameIdNumber != 0)
        console.log('Getting players...');
        api.get('games/' + gameIdNumber + '/players').then(response => {
            console.log("Players data:");
            console.log(response.data);
            setPlayers(response.data);
        })
    },
    [] //no parameter passed. This means the method above will be called only once
    )

    return (
        <div className='players-wrapper'>
            <div className='players-summary'>
                <h3>Players: </h3>
                <table>
                    {
                        playersData.map(player => (
                            <Player id={player.id} name={player.name} points={player.points} gameId={gameIdNumber} />
                    ))
                }
                </table>
                <div className="field">
                    <input 
                        type="text" 
                        name="playerName" 
                        id="playerName" 
                        placeholder="New Player"
                    />
                    <Link onClick={ 
                            () => {
                                const input = document.getElementById('playerName') as HTMLInputElement | null;
                                const playerNameValue = input?.value || "New Player";
                                newPlayer(playerNameValue, gameIdNumber);
                                Players();
                            } 
                        } to={{}}
                        > &nbsp;&nbsp;
                        <FiPlusCircle />
                    </Link>
                </div>
            </div>
            <div className="player-cards">
                <PlayerHand />
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