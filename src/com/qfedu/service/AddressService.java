package com.qfedu.service;

import com.qfedu.entity.Address;

public interface AddressService {
    /**
     * 通过用户id查找地址信息
     *
     * @param uid 用户id
     * @return 返回此用户的地址信息
     */
    Address findDefaultByUid(int uid);
}
