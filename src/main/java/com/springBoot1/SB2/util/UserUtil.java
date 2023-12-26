package com.springBoot1.SB2.util;

import com.springBoot1.SB2.config.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
    public static String getCurrentUsername(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
