package pl.amilosh.poc.service.impl;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;
import pl.amilosh.poc.mapper.UserMapper;
import pl.amilosh.poc.repository.UserRepository;
import pl.amilosh.poc.service.UserService;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${users.csv.file.name}")
    private String usersCsvFileName;

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ResourceLoader resourceLoader;

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(UserDto dto) {
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }

    @Override
    public void fillUsersFromCsv() {
        List<User> users = new ArrayList<>();

        var resource = resourceLoader.getResource("classpath:csv/" + usersCsvFileName);

        try (var inputStream = resource.getInputStream();
             var inputStreamReader = new InputStreamReader(inputStream);
             var csvReader = new CSVReader(inputStreamReader)) {
            String[] nextRecord;
            csvReader.skip(1);
            while ((nextRecord = csvReader.readNext()) != null) {
                var firstName = nextRecord[0];
                var lastName = nextRecord[1];

                var user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
                users.add(user);
            }

        } catch (Exception e) {
            log.error("Failed to read users from usersCsvFileName file: {}", e.getMessage());
        }

        userRepository.saveAll(users);
        log.error("{} users from usersCsvFileName successfully saved to DB", users.size());
    }
}
