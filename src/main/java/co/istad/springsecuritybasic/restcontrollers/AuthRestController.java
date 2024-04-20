package co.istad.springsecuritybasic.restcontrollers;

import co.istad.springsecuritybasic.model.dto.UserRequest;
import co.istad.springsecuritybasic.model.dto.UserResponse;
import co.istad.springsecuritybasic.service.UserService;
import co.istad.springsecuritybasic.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {
    private final UserService userService;

    @PostMapping("/register")
    public BaseResponse<UserResponse> createNewUser(@RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));

    }
}
