package com.ug.producciones.cientificas.Controladores;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.producciones.cientificas.DTOs.Auth.LoginDTO;
import com.ug.producciones.cientificas.DTOs.Auth.NuevoUsuarioDTO;
import com.ug.producciones.cientificas.Entidades.Rol;
import com.ug.producciones.cientificas.Entidades.Usuario;
import com.ug.producciones.cientificas.Seguridad.JWT.JwtProvider;
import com.ug.producciones.cientificas.Seguridad.Utilidades.CookieUtil;
import com.ug.producciones.cientificas.Servicios.Implementacion.RolService;
import com.ug.producciones.cientificas.Servicios.Interfaces.IUsuarioService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IUsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final RolService rolService;
    
    @Value("${jwt.accessTokenCookieName}")
    private String cookieName;
    
    @Autowired
    public AuthController(IUsuarioService usuarioService, AuthenticationManager authenticationManager,
            JwtProvider jwtProvider, PasswordEncoder passwordEncoder, RolService rolService) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.rolService = rolService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Object> registro(@Valid @RequestBody NuevoUsuarioDTO usuario, BindingResult bindingResult) throws InterruptedException, ExecutionException {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Revise los campos e intente nuevamente", HttpStatus.BAD_REQUEST);
        Usuario user = new Usuario();
        user.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        user.setCorreo(usuario.getCorreo());
        user.setDni(usuario.getDni());
        user.setCorreo(usuario.getCorreo());
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName("ROLE_USER").get().get());
        if (usuario.getRoles().contains("ROLE_ADMIN"))
            roles.add(rolService.getByRolName("ROLE_ADMIN").get().get());
        user.setRoles(roles);
        
        usuarioService.guardarUsuario(user); 
        return new ResponseEntity<>("Registro exitoso! Inicie sesión", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(HttpServletResponse httpServletResponse,@Valid @RequestBody LoginDTO loginUser, BindingResult bidBindingResult){
       /*  if(bidBindingResult.hasErrors())
        
            return new ResponseEntity<>("Revise sus credenciales"+bidBindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST); */
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getDni(), loginUser.getContraseña())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        CookieUtil.create(httpServletResponse, cookieName, jwt, false, -1, "localhost");
                return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
                return new ResponseEntity<>("Revise sus credenciales", HttpStatus.BAD_REQUEST);
        }
    }
   

}
