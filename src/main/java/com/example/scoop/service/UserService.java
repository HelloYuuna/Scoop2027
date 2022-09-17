package com.example.scoop.service;

import com.example.scoop.domain.User;
import com.example.scoop.domain.UserDTO;

public interface UserService {

    boolean findById(String email);

    User insertMember(UserDTO user);
}
