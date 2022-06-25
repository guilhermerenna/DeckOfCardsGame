import { url } from 'inspector';
import React from 'react';
import { Link } from 'react-router-dom';

interface GameProps {
  id: number;
  gameName: string;
}

const Game: React.FC<GameProps> = (props) => {
  return (
      <div className='games'>
        <Link to={'/games/' + props.id}>
          <span>ID {props.id} - {props.gameName}</span>
        </Link>
      </div>
  );
}

export default Game;