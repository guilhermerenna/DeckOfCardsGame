import React, { useEffect, useState } from 'react';
import api from '../../../services/api';
import Card from './Card';

interface CardsProps {
    playerName: string;
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

const PlayerHand: React.FC<CardsProps> = (props) => {
    const[playerHand, setHand] = useState<Card[]>([]);

    useEffect(() => {
      api.get('games/'+props.gameId+'/playerhand/'+props.playerId).then(response => {
        console.log(response.data);
        setHand(response.data);
      })
    },
    [] //no parameter passed. This means the method above will be called only once
    )

    // const Players: React.FC<PlayersProps> = (props) => {
  return (
    <div className='player-cards'>
      <h3>{props.playerName}'s Cards:</h3>
      <div className='cards-summary'>
        {
          playerHand.map(playerHand => (
            <Card cvalue={playerHand.cvalue} suit={playerHand.suit} />
            ))}
      </div>
    </div>
  );
}

export default PlayerHand;