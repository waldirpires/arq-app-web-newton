package com.example.demojwt.api;

import com.example.demojwt.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private String mobile;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private LocalDateTime lastLoginAt;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
        this.lastLoginAt = user.getLastLoginAt();
    }
}
