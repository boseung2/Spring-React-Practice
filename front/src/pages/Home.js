import React from 'react';
import { Button } from '@material-ui/core';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <Link to={'/board'}>
        <Button variant="contained" color="primary">Board</Button>
      </Link>
    </div>
  );
};

export default Home;