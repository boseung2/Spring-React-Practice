import client from './client'

export const search = ({page, size}) =>
  client.get('/api/board', { params : {page, size} });