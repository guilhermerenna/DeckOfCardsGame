import React from 'react';
import { FiX } from 'react-icons/fi'
import { GiCardDraw } from 'react-icons/gi'
import { CgCardSpades } from 'react-icons/cg'
import Players from './Players';
import { Link } from 'react-router-dom';

interface PlayerProps {
    id: number;
    name: string;
    points: number;
}

const Player: React.FC<PlayerProps> = (props) => {  
  return (
      <div className="player">
        {props.name} 
        <Link className="deleteIcon" /* onClick={() => {
          deletePlayer(props.id);
          Players(); }
        }}*/ to="/player">
          <FiX className='remove-player-icon' />
        </Link>
        
         - {props.points} points - <GiCardDraw /> <CgCardSpades />      </div>
  );
}

export default Player;