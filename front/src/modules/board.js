import { createAction, handleActions } from 'redux-actions';
import createRequestSaga, { createRequestActionTypes } from '../lib/createRequestSaga';
import * as boardAPI from '../lib/api/board';
import { takeLatest } from '@redux-saga/core/effects';

const CHANGE_FIELD = "board/CHANGE_FIELD";
const INITIALIZE_FORM = "board/INITIALIZE_FORM";
const [SEARCH, SEARCH_SUCCESS, SEARCH_FAILURE] =
  createRequestActionTypes('board/SEARCH')

export const changeField = createAction(
  CHANGE_FIELD,
  ({page, size}) => ({
    page,
    size
  })
)

export const initializeForm = createAction(
  INITIALIZE_FORM,
)

export const search = createAction(
  SEARCH, ({page, size}) => ({
    page,
    size
  })
)

const searchSaga = createRequestSaga(SEARCH, boardAPI.search);
export function* boardSaga() {
  yield takeLatest(SEARCH, searchSaga);
}


const initialState = {
  dtoList : [],
  totalPage : '',
  page : '',
  size : '',
  prev : null,
  next : null,
  boardError : null
}

const board = handleActions(
  {
  [CHANGE_FIELD]: (state, { payload: { page, size } }) => ({
     ...state,
     page,
     size
    }),
    [SEARCH_SUCCESS]: (state, { payload: dtoList }) => ({
     ...state,
      dtoList
    }),
  },
  initialState
);

export default board;