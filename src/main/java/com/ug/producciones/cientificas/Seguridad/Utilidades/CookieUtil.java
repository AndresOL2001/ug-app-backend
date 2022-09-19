package com.ug.producciones.cientificas.Seguridad.Utilidades;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CookieUtil {
    
    public static void create(HttpServletResponse res,String name,String value,Boolean secure,Integer maxAge,String domain){
        Cookie cookie = new Cookie(name,value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        res.addCookie(cookie);
    }

    public static void clear(HttpServletResponse res,String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1);
        cookie.setDomain("localhost");
        res.addCookie(cookie);
    }
}