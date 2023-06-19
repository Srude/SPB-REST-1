package com.spb.webserver11.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String name;
    private String email;
    private String organization;

    @Override
    public String toString() {
        return "MemberDTO {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }

}
