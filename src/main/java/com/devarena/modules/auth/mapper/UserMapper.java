package com.devarena.modules.auth.mapper;

import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.response.UserResponse;
import com.devarena.modules.auth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(RegisterRequest registerRequest);

    @Mapping(expression = "java(user.getId())", target = "id")
    @Mapping(expression = "java(user.getEmail())", target = "email")
    @Mapping(expression = "java(user.getDisplayName())", target = "displayName")
    @Mapping(expression = "java(user.getAvatarUrl())", target = "avatarUrl")
    @Mapping(expression = "java(user.getXp())", target = "xp")
    @Mapping(expression = "java(user.getLevel())", target = "level")
    @Mapping(expression = "java(user.getRole() != null ? user.getRole().name() : null)", target = "role")
    @Mapping(expression = "java(user.getCreatedAt())", target = "createdAt")
    UserResponse toUserResponse(User user);
}
