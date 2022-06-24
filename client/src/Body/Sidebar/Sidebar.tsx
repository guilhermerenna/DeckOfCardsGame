import React from 'react';
import './Sidebar.css';

import UndealtDecks from './UndealtDecks/UndealtDecks';
import Games from './Games/Games';

function Sidebar() {
  return (
      <div className='sidebar'>
        <UndealtDecks />
        <Games />
      </div>
  );
}

export default Sidebar;