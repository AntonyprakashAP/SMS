package com.algoriant.sms.controller;

import com.algoriant.sms.entity.Role;
import com.algoriant.sms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);
    }
}
