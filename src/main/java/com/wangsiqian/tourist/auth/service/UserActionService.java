package com.wangsiqian.tourist.auth.service;

import com.wangsiqian.tourist.auth.dto.LoginDTO;
import com.wangsiqian.tourist.common.utils.CommonResult;

/** @author wangsiqian */
public interface UserActionService {
    /**
     * 后台登陆接口
     *
     * @param loginDTO 登陆账号数据
     * @return 登陆验证结果
     */
    CommonResult<String> login(LoginDTO loginDTO);
}
