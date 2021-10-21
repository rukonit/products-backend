package com.rukon.mapper;

import com.rukon.dto.UserDto;
import com.rukon.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {User.class})
public interface UserDtoMapper {
    UserDto map(User user);
    Set<UserDto> map(Set<User> user);


}
