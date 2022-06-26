import React, { useEffect, useState } from 'react';
import api from '../../../services/api';
import './Shoe.css';
import SuitEntry from './SuitEntry'

interface SuitListingProps {
    gameId: number;
    suit: string;
}

interface SuitEntry {
  card: number;
  count: number;
}

const SuitListing: React.FC<SuitListingProps> = (props) => {
  const[suitListing, setSuitListings] = useState<SuitEntry[]>([]);

  useEffect(() => {
    api.get( 'games/'+ props.gameId+"/listsuit/"+props.suit).then(response => {
      console.log(response.data.entries);
      setSuitListings(response.data.entries);
    });
  }, [])
  
  let color = "black"
  if(props.suit == "h" || props.suit == "d") color = "red";
  return (
    <div className='shoe-listing'>
      <div className={"shoe-card-list-" + color}>
        <ul className="cards-grid">
            {
                suitListing.map(suitEntry => (
                <SuitEntry card={suitEntry.card} suit={props.suit} count={suitEntry.count} />
            ))}
        </ul>
      </div>
    </div>
  );
}


export default SuitListing