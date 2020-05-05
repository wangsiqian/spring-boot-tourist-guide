package com.wangsiqian.tourist.session;

import com.wangsiqian.tourist.session.dto.LoginDTO;
import com.wangsiqian.tourist.session.service.impl.SessionServiceImpl;
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
public class SessionController {
    private final SessionServiceImpl sessionService;

    @PostMapping("/login")
    public CommonResult<String> login(@RequestBody @Validated LoginDTO loginDTO) {
        return sessionService.login(loginDTO);
    }
}
