package br.com.smartmenu.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String name;
    private String email;
    private String login;
    private String password;
    private LocalDateTime lastChangeDate;


}
