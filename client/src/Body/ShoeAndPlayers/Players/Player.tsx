import React from 'react';
import { FiX } from 'react-icons/fi'
import { GiCardDraw } from 'react-icons/gi'
import { CgCardSpades } from 'react-icons/cg'
import { Link, useParams } from 'react-router-dom';
import api from '../../../services/api';
import Players from './Players';
import PlayerHand from './Cards/PlayerHand';

interface PlayerProps {
    id: number;
    name: string;
    points: number;
    gameId: number;
}

const Player: React.FC<PlayerProps> = (props) => {

  return (
    <>
      <tr className="player">
        <td>
          <Link to={`/games/${props.gameId}/players/${props.id}`} onClick={
            () => {
              PlayerHand();
            }
          }>
            {props.id}: {props.name} 
          </Link>
        </td>
        <td>
          <Link className="deleteIcon" onClick={() => {
            deletePlayer(props.id);
            Players(); 
          }} to="/player">
            <FiX className='remove-player-icon' />
          </Link>&nbsp;&nbsp;
        </td>
        <td>
         {props.points} points &nbsp;&nbsp;
        </td>
        <td>
          <Link onClick={() => {
              console.log("Drawn card: " + drawCard(props.gameId, props.id));
              Players();
            }} to={{}}>
          <GiCardDraw />&nbsp;&nbsp;
          </Link> 
        </td>
      </tr>
    </>
  );
}

async function deletePlayer(id: number) {
  const res = await api.delete('players/'+ id);
}

async function drawCard(gameId: number, playerId: number) {
  return api.get('games/' + gameId + '/deal/' + playerId)
}

export default Player;