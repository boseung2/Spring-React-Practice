import React from 'react';
import { Button, TextField } from '@material-ui/core';

const BoardReadForm = () => {
  return (
    <>
      <TextField
        id="standard-full-width"
        label="Bno"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <TextField
        id="standard-full-width"
        label="Title"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <TextField
        id="standard-full-width"
        label="Content"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
        multiline
        rows={5}
      />
      <TextField
        id="standard-full-width"
        label="Writer"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <TextField
        id="standard-full-width"
        label="Regdate"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <TextField
        id="standard-full-width"
        label="Moddate"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <Button variant='contained' color='primary'>Submit</Button>
      <Button variant='contained' style={{'marginLeft' : '0.5rem'}}>List</Button>
    </>
  );
}

export default BoardReadForm;