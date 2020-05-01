package com.wangsiqian.tourist.auth;

import com.wangsiqian.tourist.auth.dto.LoginDTO;
import com.wangsiqian.tourist.auth.service.impl.UserActionServiceImpl;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserActionController {
    private final UserActionServiceImpl userActionService;

    @PostMapping("/login")
    public CommonResult<String> login(@RequestBody @Validated LoginDTO loginDTO) {
        return userActionService.login(loginDTO);
    }
}
