package org.gadconsulting.homeschedules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zip;
}
