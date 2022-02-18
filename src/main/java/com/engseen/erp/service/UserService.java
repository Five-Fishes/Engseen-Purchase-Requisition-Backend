package com.engseen.erp.service;

import com.engseen.erp.service.dto.LoginDTO;

public interface UserService {
    String getUserAuthority(String userId);

    String login(LoginDTO loginDTO) throws Exception;
}
