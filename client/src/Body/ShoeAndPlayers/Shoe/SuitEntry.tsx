import React from 'react';
import './Shoe.css';
import api from '../../../services/api';

interface SuitEntryProps {
    card: number;
    suit: string;
    count: number;
}

const SuitListing: React.FC<SuitEntryProps> = (props) => {
    let suitSymbol = "?";
    switch (props.suit) {
        case "h":
            suitSymbol = "♥";
            break;
        case "s":
            suitSymbol = "♠";
            break;
        case "c":
            suitSymbol = "♣";
            break;
        case "d":
            suitSymbol = "♦";
            break;
    }

    return (
      <p>{props.card} {suitSymbol} : {props.count} cards left</p>
  );
}

export default SuitListing