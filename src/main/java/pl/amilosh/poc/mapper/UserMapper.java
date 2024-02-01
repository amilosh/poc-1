package pl.amilosh.poc.mapper;

import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.amilosh.poc.dto.UserDto;
import pl.amilosh.poc.entity.User;

@Component
@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User user);
}
