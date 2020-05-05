package com.wangsiqian.tourist.session.service;

import com.wangsiqian.tourist.session.dto.LoginDTO;
import com.wangsiqian.tourist.common.utils.CommonResult;

/** @author wangsiqian */
public interface SessionService {
    /**
     * 后台登陆接口
     *
     * @param loginDTO 登陆账号数据
     * @return 登陆验证结果
     */
    CommonResult<String> login(LoginDTO loginDTO);
}
