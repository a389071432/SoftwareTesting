import request from '../utils/request';

export const fetchResult = data => {
    return request({
        url: '/test',
        method: 'post',
        data
    });
};
