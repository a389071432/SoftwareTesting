import request from '../utils/request';

export const fetchResult = query => {
  return request({
    url: '/test',
    method: 'get',
    params: {
      question:query.question,
      tableData:query.tableData
    }
  });
};
