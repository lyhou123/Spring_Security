package co.istad.springsecuritybasic.service;

import co.istad.springsecuritybasic.model.dto.UserRequest;
import co.istad.springsecuritybasic.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
