import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import BoardTable from '../../components/board/BoardTable';
import { search } from '../../modules/board';

const BoardTableContainer = () => {
  const dispatch = useDispatch();
  const { dtoList, totalPage, page } = useSelector(({dtoList, totalPage, page}) => ({
    dtoList,
    totalPage,
    page,
  }))

  return (
    <>
      <BoardTable />
    </>
  );
};

export default BoardTableContainer;