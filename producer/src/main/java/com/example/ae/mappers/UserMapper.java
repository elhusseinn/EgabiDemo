package com.example.ae.mappers;

import com.example.ae.models.User;
import com.example.ae.pojo.UserPOJO;
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
