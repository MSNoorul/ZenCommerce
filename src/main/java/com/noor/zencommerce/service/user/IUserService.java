package com.noor.zencommerce.service.user;

import com.noor.zencommerce.dto.UserDto;
import com.noor.zencommerce.model.User;
import com.noor.zencommerce.request.CreateUserRequest;
import com.noor.zencommerce.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
