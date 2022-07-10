import React from 'react';
import './App.css';

import {
  BrowserRouter as Router,
  Route,
  Link
} from "react-router-dom";

import Home from './Home/Home';

function App() {
  return (
    <>
      <Router>
        <div className="App">
        <Home />
        </div>
      </Router>
    </>
  );
}

export default App;
