import React from 'react';
import BoardSearch from './BoardSearch';
import BoardTable from './BoardTable';
import BoardTitle from './BoardTitle';
import { Container } from '@material-ui/core';

const BoardListTemplate = () => {
  return (
    <div>
      <Container maxWidth="lg">
      <BoardTitle/>
      <BoardSearch/>
      <BoardTable/>
      </Container>
    </div>
  );
};

export default BoardListTemplate;