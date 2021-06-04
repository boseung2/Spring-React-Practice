import React from 'react';
import { Button, TextField } from '@material-ui/core';

const BoardRegisterForm = ({ title }) => {
  return (
    <>
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
        label="Writer Email"
        fullWidth
        margin="normal"
        InputLabelProps={{
          shrink: true,
        }}
      />
      <Button variant='contained' color='primary'>Submit</Button>
      {title === "Modify" ?
        (
          <>
            <Button variant='contained' color='secondary' style={{'marginLeft' : '0.5rem'}}>Remove</Button>
            <Button variant='contained' style={{'marginLeft' : '0.5rem'}}>List</Button>
          </>
        ):
        ''
      }
    </>
  );
}

export default BoardRegisterForm;