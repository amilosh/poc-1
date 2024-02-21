package pl.amilosh.poc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;
import pl.amilosh.poc.mapper.UserMapper;
import pl.amilosh.poc.service.UserService;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return userMapper.toDto(user);
        } else {
            return null;
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto dto) {
        User user = userService.create(dto);
        return userMapper.toDto(user);
    }

    @PostMapping(value = "/fill-users-from-csv")
    @ResponseStatus(HttpStatus.OK)
    public void fillUsersFromCsv() {
        userService.fillUsersFromCsv();
    }
}
