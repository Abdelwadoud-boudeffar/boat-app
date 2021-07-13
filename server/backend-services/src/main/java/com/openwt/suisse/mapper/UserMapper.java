package com.openwt.suisse.mapper;

import com.openwt.suisse.dao.model.User;
import com.openwt.suisse.dto.UserViewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "firstName", target = "firstName")
    UserViewDTO userToUserViewDto(User user);
}
