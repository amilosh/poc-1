package pl.amilosh.poc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
}
