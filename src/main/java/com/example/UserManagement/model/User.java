package com.example.UserManagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class User {
    @NonNull
    private Integer userId;

    @NotEmpty
    private String userName;

    @Email
    private String userEmail;
    private String password;

    @Pattern(regexp = "\\d{10}")
    private String userContact;
    private Integer userAge;
    private LocalDate userDOB;
    private Type userType;

}
