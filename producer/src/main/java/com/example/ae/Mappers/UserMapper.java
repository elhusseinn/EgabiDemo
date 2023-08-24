package com.example.ae.Mappers;

import com.example.ae.Models.User;
import com.example.ae.POJO.UserPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User mapToUser (UserPOJO userPOJO);
    @Mapping(source = "password", ignore= true, target = "password")
    UserPOJO mapToUserPOJO (User user);
}
