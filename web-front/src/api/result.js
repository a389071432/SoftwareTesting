import request from '../utils/request';

export function fetchResult(query) {
    return request({
        url: '/api/result',
        method: 'get',
        params: query
    })
}