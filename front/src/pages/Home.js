import React from 'react';
import { Link } from 'react-router-dom';
import { Button } from '@material-ui/core';
import { styled } from '@material-ui/styles';
import Header from "../components/common/Header";

const StyledButton = styled(Button)({
  background: 'linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)',
  border: 0,
  borderRadius: 3,
  boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
  color: 'white',
  height: 48,
  padding: '0 30px',
  margin : '1rem'
});

const Home = () => {

  return (
    <div>
      <Header/>
      <Link to={'/board'}>
        <StyledButton variant="contained">Board</StyledButton>
      </Link>
    </div>
  );
};

export default Home;