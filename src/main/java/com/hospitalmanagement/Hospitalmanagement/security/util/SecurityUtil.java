/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.Hospitalmanagement.security.util;

import com.hospitalmanagement.Hospitalmanagement.security.AccessTokenUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author nirmal
 */
public final class SecurityUtil {

    private SecurityUtil() {
    }

    public static Integer getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        Object principal = auth.getPrincipal();
        if (!(principal instanceof AccessTokenUserDetails)) {
            return null;
        }

        return ((AccessTokenUserDetails) principal).userId;
    }
}
