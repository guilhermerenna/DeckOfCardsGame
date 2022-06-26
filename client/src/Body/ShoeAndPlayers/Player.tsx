import React from 'react';
import { FiX } from 'react-icons/fi'
import { GiCardDraw } from 'react-icons/gi'
import { CgCardSpades } from 'react-icons/cg'
import Players from './Players';
import { Link } from 'react-router-dom';
import api from '../../services/api'

interface PlayerProps {
    id: number;
    name: string;
    points: number;
    gameId: number;
}

const Player: React.FC<PlayerProps> = (props) => {  
  return (
      <div className="player">
        {props.id} - {props.name} 
        <Link className="deleteIcon" onClick={() => {
          deletePlayer(props.id);
          Players({gameId: props.id}); 
        }} to="/player">
          <FiX className='remove-player-icon' />
        </Link>
        
         - {props.points} points - <GiCardDraw /> <CgCardSpades />      </div>
  );
}

async function deletePlayer(id: number) {
  const res = await api.delete('players/'+ id);
}

export default Player;