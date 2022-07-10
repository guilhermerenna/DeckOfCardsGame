import React, { useEffect, useMemo, useState } from 'react';
import './ShoeAndPlayers.css';
import Shoe from './Shoe/Shoe';
import Players from './Players/Players';
import { Route, Routes } from 'react-router-dom';
import ShoeAndPlayersEmpty from './ShoeAndPlayersEmpty';

const ShoeAndPlayers = () => {

  return (
    <Routes>
      <Route path='/games/:gameId' element={
        <>
          <Shoe />
          <Players />
        </>
      }></Route>
      <Route path='/games/:gameId/players/:playerId' element={
        <>
          <Shoe />
          <Players />
        </>
      }></Route>
      <Route path='/*' element={
        <>
          <ShoeAndPlayersEmpty />
        </>
      }></Route>
    </Routes>
  );
}

export default ShoeAndPlayers;