import React, { useEffect, useState } from 'react';
import api from '../../../services/api';

interface SuitStatisticsProps {
    gameId: number;
    suit: string;
}

interface SuitStatisticsEntry {
  count: number;
}

const SuitStatisticsEntry: React.FC<SuitStatisticsProps> = (props) => {
    const[statsData, setStatsData] = useState<number>();

    useEffect(() => {
        api.get( 'games/'+ props.gameId+"/countsuit/"+props.suit.charAt(0)).then(response => {
          console.log("Stats for "+props.suit+":");
            console.log(response.data);
          setStatsData(response.data);
        });
      }, [])

  return (
    <div className='suit-statistics-listing'>
        {statsData} {props.suit}
    </div>
  );
}


export default SuitStatisticsEntry