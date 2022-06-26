import React, { useEffect, useState } from 'react';
import './Card.css';

interface CardProps {
  suit: string;
  cvalue: number;
}

const Card: React.FC<CardProps> = (props) => {  
  const [color, setColor] = useState("");
  const [icon, setIcon] = useState("");
  const [face, setFace] = useState("");
  
  useEffect(() => {
    if(props.suit == "s") {setIcon("♠"); setColor("black")};
    if(props.suit == "c") {setIcon("♣"); setColor("black")};
    if(props.suit == "h") {setIcon("♥"); setColor("red")};
    if(props.suit == "d") {setIcon("♦"); setColor("red")};

    setFace(props.cvalue.toString());
    if(props.cvalue == 1) setFace("A");
    if(props.cvalue == 11) setFace("J");
    if(props.cvalue == 12) setFace("Q");
    if(props.cvalue == 13) setFace("K");
  }, [])

  return (
    <div className={`wrapper ${color}`}>
      <div className='cvalue top-left'>{face}</div>
      <div className='symbols'>
        <div className='symbol'>{icon}</div>
      </div>
      <div className='cvalue bottom-right'>{face}</div>
    </div>  
  );
}

export default Card;