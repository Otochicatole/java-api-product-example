package dev.otochi.ecommerce.mapper;

import dev.otochi.ecommerce.dto.UserDTO;
import dev.otochi.ecommerce.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToDTO(UserEntity entity);

    List<UserDTO> userEntityListToDTOList(List<UserEntity> entity);
}
