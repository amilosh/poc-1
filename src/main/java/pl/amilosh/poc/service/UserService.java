package pl.amilosh.poc.service;

import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;

public interface UserService {

    User getUserById(Integer id);

    User create(UserDto dto);

    void fillUsersFromCsv();
}
