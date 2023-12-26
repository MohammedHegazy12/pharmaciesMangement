package com.springBoot1.SB2.dto.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class UpdateRoleDTO {
    private String name;//role name
    private Short priority;
    private Set<Integer> authorities;
}
