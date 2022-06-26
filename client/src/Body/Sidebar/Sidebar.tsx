import React from 'react';
import './Sidebar.css';

import Games from './Games/Games';

function Sidebar() {
  return (
      <div className='sidebar'>
        <Games />
      </div>
  );
}

export default Sidebar;