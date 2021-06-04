import React from 'react';
import {
  Button,
  FormControl,
  Grid,
  InputLabel,
  makeStyles,
  MenuItem,
  Select,
  TextField,
} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  ButtonStyles : {
    height : 40
  }
}));

const BoardSearch = ({ age, handleChange }) => {

  const classes = useStyles();

  return (
    <Grid container spacing={1}>
      <Grid item xs={12} sm={2}>
        <FormControl variant="outlined" fullWidth size="small">
          <InputLabel id="demo-simple-select-outlined-label">선택</InputLabel>
          <Select
            labelId="demo-simple-select-outlined-label"
            id="demo-simple-select-outlined"
            value={age}
            onChange={handleChange}
            label="Age"
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            <MenuItem value={10}>Ten</MenuItem>
            <MenuItem value={20}>Twenty</MenuItem>
            <MenuItem value={30}>Thirty</MenuItem>
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={6}>
        <TextField id="outlined-basic" label="내용" variant="outlined" fullWidth size="small"/>
      </Grid>
      <Grid item xs={12} sm={2}>
        <Button className={classes.ButtonStyles} variant="outlined" fullWidth>Search</Button>
      </Grid>
      <Grid item xs={12} sm={2}>
        <Button className={classes.ButtonStyles} variant="outlined" fullWidth>Clear</Button>
      </Grid>
    </Grid>
  )
};

export default BoardSearch;