import React from 'react';
import { Link } from 'react-router-dom';
import { Box, Button, makeStyles } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  button : {
    margin : theme.spacing(1),
  },
}));

const BoardTitle = ({ title }) => {

  const classes = useStyles();

  return (
    <div>
      <Box display="flex" alignItems="center">
        <h1>Board {title} Page</h1>
        {title === "List" ? <Link to={'/board/register'}><Button variant="outlined" color="secondary" className={classes.button}>REGISTER</Button></Link> : ''}
      </Box>
    </div>
  );
};

export default BoardTitle;