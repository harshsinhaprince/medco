package com.medicine.userService.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class JwtResponse {
    private String jwtToken;
    private String username;
}
