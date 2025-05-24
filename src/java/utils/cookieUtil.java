/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author thang
 */
public class cookieUtil{
    
    private final int MaxAge = 60 * 60 * 24 * 7; // max date unit is second
    
    // key
    public String user = "user_id";
    
    
    
    
    public String getCookie(HttpServletRequest req, String key) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
    
    public void setCookie(HttpServletResponse res, String key, String value) throws IOException {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(MaxAge); // 7 days
        res.addCookie(cookie);
    }
    
}
