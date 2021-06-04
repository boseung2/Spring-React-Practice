import React from 'react';
import BoardTitle from './BoardTitle';
import { Container } from '@material-ui/core';
import BoardRegisterForm from './BoardRegisterForm';

const BoardRegisterTemplate = ({ title }) => {
  return (
    <div>
      <Container maxWidth="lg">
        <BoardTitle title={title}/>
        <BoardRegisterForm title={title}/>
      </Container>
    </div>
  );
};

export default BoardRegisterTemplate;