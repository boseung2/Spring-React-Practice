import React from 'react';
import BoardTitle from './BoardTitle';
import { Container } from '@material-ui/core';
import BoardReadForm from './BoardReadForm';

const BoardReadTemplate = () => {
  return (
    <div>
      <Container maxWidth="lg">
        <BoardTitle title="Read"/>
        <BoardReadForm/>
      </Container>
    </div>
  );
};

export default BoardReadTemplate;