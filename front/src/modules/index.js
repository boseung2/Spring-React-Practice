import board, { boardSaga } from './board';
import loading from './loading';
import { combineReducers } from 'redux';
import { all } from 'redux-saga/effects';

const rootReducer = combineReducers({
  board,
  loading,
})

export function* rootSaga() {
  yield all([boardSaga()]);
}

export default rootReducer;