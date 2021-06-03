import React from 'react';
import { Link } from 'react-router-dom';
import { Box, Button, makeStyles } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  button : {
    margin: theme.spacing(1),
  },
}));

const BoardTitle = () => {

  const classes = useStyles();

  return (
    <div>
      <Box display="flex" alignItems="center">
      <h1>Board List Page</h1>
      <Link to={'/board/register'}><Button variant="contained" color="secondary" className={classes.button}>REGISTER</Button></Link>
      </Box>
    </div>
  );
};

export default BoardTitle;