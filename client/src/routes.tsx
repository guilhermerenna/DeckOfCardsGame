import React from 'react';
import { Route, BrowserRouter } from 'react-router-dom'; 
import ShoeAndPlayers from './Body/ShoeAndPlayers/ShoeAndPlayers';

import Home from './Home/Home';

const Routes = (gameId: number) => {
    return (
        <>
            <Home />
            <ShoeAndPlayers />
        </>
    );
}

export default Routes; 