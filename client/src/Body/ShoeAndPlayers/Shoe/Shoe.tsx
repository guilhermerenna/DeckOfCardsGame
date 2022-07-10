import React from 'react';
import './Shoe.css';
import { FiPlusCircle, FiShuffle } from 'react-icons/fi';
import SuitListing from './SuitListing';
import SuitStatisticsList from './SuitStatisticsList';
import { Link, useParams } from 'react-router-dom';
import api from '../../../services/api';
import ShoeAndPlayers from '../ShoeAndPlayers';

const Shoe = () => {
  const {gameId} = useParams();
  const gameIdNumber = parseInt(gameId || '0');
  
  return (
      <div className='shoe'>
        <div className='shoe-summary-grid'>
          <div className='shoe-grid-entry'>
            <h3>Game Shoe - {gameId} &nbsp;&nbsp;
              <Link to={{}} onClick={
                () => {
                  let totalCards = shuffle(gameIdNumber).then(
                    function (error) {
                      alertShuffle();
                    }
                  );
                }
              }>
                <FiShuffle />&nbsp;&nbsp;
              </Link>
              <Link to={{}} onClick={
                () => {
                  console.log("Deck added and now we have " + api.get('games/' + gameIdNumber + '/adddeck'));
                  Shoe();
                }
              }>
               <FiPlusCircle />&nbsp;&nbsp;
              </Link>
              </h3>
          </div>
          <div>Cards left in the game:</div>
          <SuitStatisticsList gameId={gameIdNumber}/>
        </div>
        <div className="shoe-card-list">
          <SuitListing gameId={gameIdNumber} suit="h" />
          <SuitListing gameId={gameIdNumber} suit="s" />
          <SuitListing gameId={gameIdNumber} suit="c" />
          <SuitListing gameId={gameIdNumber} suit="d" />
        </div>
      </div>
  );
}

async function shuffle(gameId: number) {
  api.get('games/' + gameId + '/shuffle');
}

async function alertShuffle() {
  alert("Shuffled deck successfully.");
}

export default Shoe