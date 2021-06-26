import React from 'react';
import { AppBar, makeStyles, Toolbar, Typography } from '@material-ui/core';
import Button from "@material-ui/core/Button";
import theme from "../../theme";
import {Link} from "react-router-dom";

const useStyles = makeStyles(() => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
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
              <Link to={'/'}>
              Home
              </Link>
            </Typography>
            <Link to={'/login'}>
            <Button color="inherit">Login</Button>
            </Link>
          </Toolbar>
        </AppBar>
      </div>
    </div>
  );
};

export default Header;