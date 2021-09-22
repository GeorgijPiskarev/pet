package com.my.pet.model.mapstruct;

import com.my.pet.model.entity.User;
import com.my.pet.model.dto.UserDto;
import com.my.pet.model.mapstruct.config.IgnoreUnmappedMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
public interface UserMapper {

    UserDto toUserDto(User user);
}
