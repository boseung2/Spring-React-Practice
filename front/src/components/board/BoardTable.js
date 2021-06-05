import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Pagination from '@material-ui/lab/Pagination';

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
  },
}))(TableRow);

function createData(bno, title, replyCount,  writer, regdate) {
  return { bno, title, replyCount, writer, regdate };
}

const rows = [
  createData(100, 'test title', 10,'test writer', '2020/01/01'),
  createData(101, 'test title', 10,'test writer', '2020/01/01'),
  createData(102, 'test title', 10,'test writer', '2020/01/01'),
  createData(103, 'test title', 10,'test writer', '2020/01/01'),
  createData(104, 'test title', 10,'test writer', '2020/01/01'),
  createData(105, 'test title', 10,'test writer', '2020/01/01'),
  createData(106, 'test title', 10,'test writer', '2020/01/01'),
  createData(107, 'test title', 10, 'test writer', '2020/01/01'),
  createData(108, 'test title', 10, 'test writer', '2020/01/01'),
  createData(109, 'test title', 10, 'test writer', '2020/01/01'),
];

const useStyles = makeStyles((theme) => ({
  tableContainer : {
    marginTop : theme.spacing(2),
  },
  table: {
    minWidth: 700,
  },
  paginationStyle : {
    marginTop: theme.spacing(2),
    '& > ul': {
      justifyContent: 'center',
    }
  }
}));

const BoardTable = ({ dtoList, totalPage, page, onClick }) => {
  const classes = useStyles();

  return (
    <>
    <TableContainer component={Paper} className={classes.tableContainer}>
      <Table className={classes.table} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell>#</StyledTableCell>
            <StyledTableCell>Title</StyledTableCell>
            <StyledTableCell>Writer</StyledTableCell>
            <StyledTableCell>Regdate</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.bno}>
              <StyledTableCell component="th" scope="row">
                {row.bno}
              </StyledTableCell>
              <StyledTableCell>{row.title} [{row.replyCount}]</StyledTableCell>
              <StyledTableCell>{row.writer}</StyledTableCell>
              <StyledTableCell>{row.regdate}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  <Pagination className={classes.paginationStyle} count={totalPage} page={page} onClick={onClick}/>
  </>
  );
};

export default BoardTable;