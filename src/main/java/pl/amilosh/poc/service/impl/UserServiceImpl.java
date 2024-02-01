package pl.amilosh.poc.service.impl;

import org.springframework.stereotype.Service;
import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;
import pl.amilosh.poc.repository.UserRepository;
import pl.amilosh.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        return userRepository.save(user);
    }
}
