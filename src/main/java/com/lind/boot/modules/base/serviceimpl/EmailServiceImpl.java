package com.lind.boot.modules.base.serviceimpl;

import com.lind.boot.modules.base.service.EmailService;
import org.springframework.stereotype.Service;

/**
 * 发邮件模拟实现.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendMail(String receiver) {

    }

    @Override
    public String sendFindPassworldMail(String receiver) {
        return null;
    }

    @Override
    public Boolean verifyCode(String username, String code) {
        return null;
    }
}
