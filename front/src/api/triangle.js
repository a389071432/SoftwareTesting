import request from '../utils/request';

export function fetchRes(query) {
  return request({
      url: '/api/triangle',
      method: 'get',
      params: query
  })
}
