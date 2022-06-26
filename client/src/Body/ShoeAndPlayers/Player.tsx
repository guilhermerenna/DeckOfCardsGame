import React from 'react';
import { FiX } from 'react-icons/fi'
import { GiCardDraw } from 'react-icons/gi'
import { CgCardSpades } from 'react-icons/cg'

interface PlayerProps {
    id: number;
    name: string;
    points: number;
}

const Player: React.FC<PlayerProps> = (props) => {  
  return (
      <div className="player">
        {props.name} - {props.points} points - <FiX /> <GiCardDraw /> <CgCardSpades />      </div>
  );
}

export default Player;