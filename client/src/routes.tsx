import React from 'react';
import { Route, BrowserRouter } from 'react-router-dom'; 
import ShoeAndPlayers from './Body/ShoeAndPlayers/ShoeAndPlayers';

import Home from './Home/Home';

const Routes = () => {
    return (
        <BrowserRouter>
            <Route path="/" >
                <Home />
            </Route>
            <Route path="/games/1">
                <ShoeAndPlayers />
            </Route>
        </BrowserRouter>
    );
}

export default Routes; 