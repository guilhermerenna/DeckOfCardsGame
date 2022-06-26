import React, { useEffect, useState } from 'react';
import api from '../../../services/api';
import SuitStatisticsEntry from './SuitStatisticsEntry'

interface SuitStatisticsProps {
    gameId: number;
}

interface SuitStatisticsEntryProps {
  card: number;
  count: number;
}

const SuitStatisticsList: React.FC<SuitStatisticsProps> = (props) => {
  return (
    <div className='shoe-listing'>
        <ul className="suit-statistics-list">
            <li className="suit-statistics-entry"><SuitStatisticsEntry gameId={props.gameId} suit="hearts" /></li>
            <li className="suit-statistics-entry"><SuitStatisticsEntry gameId={props.gameId} suit="spades" /></li>
            <li className="suit-statistics-entry"><SuitStatisticsEntry gameId={props.gameId} suit="clubs" /></li>
            <li className="suit-statistics-entry"><SuitStatisticsEntry gameId={props.gameId} suit="diamonds" /></li>

        </ul>
    </div>
  );
}


export default SuitStatisticsList