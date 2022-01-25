package com.engseen.erp.controller.rest;

import com.engseen.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/authority")
    public ResponseEntity<String> getUserAuthorityByUserId(@PathVariable String userId) {
        // TODO: [LU] Check real db role string and update accordingly
        return ResponseEntity.ok().body(userService.getUserAuthority(userId));
    }
}
