package com.engseen.erp.service.impl;

import com.engseen.erp.domain.UserMaster;
import com.engseen.erp.repository.UserMasterRepository;
import com.engseen.erp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMasterRepository userMasterRepository;

    @Override
    public String getUserAuthority(String userId) {
        Optional<UserMaster> userMasterOptional = userMasterRepository.findOneByUserID(userId);
        return userMasterOptional.isPresent() ? userMasterOptional.get().getRole() : "";
    }
}
