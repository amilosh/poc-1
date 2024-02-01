package pl.amilosh.poc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;
import pl.amilosh.poc.mapper.UserMapper;
import pl.amilosh.poc.repository.UserRepository;
import pl.amilosh.poc.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(UserDto dto) {
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }
}
