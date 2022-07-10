import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import api from '../../../../services/api';
import Card from './Card';

interface CardsProps {
    playerName?: string;
    playerId: number;
    gameId: number;
}

interface Card {
  suit: string;
  cvalue: number;
}

interface PlayerHand {
  cards: Card[];
}

const PlayerHand = () => {
  const{ gameId, playerId } = useParams();
    const gameIdNumber = parseInt(gameId || '0');
    const playerIdNumber = parseInt(playerId || '0');
    console.log(window.location.pathname + ' -- Game ' + gameId + ' , player ' + playerId);

    const[playerHand, setHand] = useState<Card[]>([]);

    useEffect(() => {
      if(playerIdNumber != 0) {
        api.get('games/'+gameIdNumber+'/playerhand/'+playerIdNumber).then(response => {
          console.log('Fetched cards for player '+playerId + ' : ' + response.data);
          setHand(response.data);
        })
      }
    },
    [] //no parameter passed. This means the method above will be called only once
    )

    // const Players: React.FC<PlayersProps> = (props) => {
    console.log('Player : ' + playerId);
    if(playerIdNumber != 0 && playerHand.length > 0) {
      return (
        <div className='player-cards'>
          <h3>Player {playerIdNumber}'s Cards:</h3>
          <div className='cards-summary'>
            {
              playerHand.map(playerHand => (
                <Card cvalue={playerHand.cvalue} suit={playerHand.suit} />
                ))}
          </div>
        </div>
      );
  } else if(playerIdNumber != 0 && playerHand.length == 0) {
    return (
      <div className='player-cards'>
        <h3>Player {playerIdNumber}'s Cards:</h3>
        <div className='cards-summary'>
            <p className='warning'>Player {playerIdNumber} has an empty hand.<br />
            Draw some cards and they will appear here.</p>
        </div>
      </div>
    );
} else {
    return <div className='player-cards'>
      <p className='warning'>Select a player to see their cards.</p>
      </div>
  }
}

export default PlayerHand;