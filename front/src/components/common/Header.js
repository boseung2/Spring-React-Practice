import React from 'react';
import { AppBar, makeStyles, Toolbar, Typography } from '@material-ui/core';

const useStyles = makeStyles(() => ({
  root: {
    flexGrow: 1,
  },
}));

const Header = () => {

  const classes = useStyles();

  return (
    <div>
      <div className={classes.root}>
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" className={classes.title}>
              Board
            </Typography>
          </Toolbar>
        </AppBar>
      </div>
    </div>
  );
};

export default Header;