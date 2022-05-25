package com.api.porfolio.security.controller;

import com.api.porfolio.model.Persona;
import com.api.porfolio.security.dto.Mensaje;
import com.api.porfolio.security.dto.JwtDto;
import com.api.porfolio.security.dto.LoginUsuario;
import com.api.porfolio.security.dto.NuevoUsuario;
import com.api.porfolio.security.entity.Usuario;
import com.api.porfolio.security.jwt.JwtProvider;
import com.api.porfolio.security.service.UsuarioService;
import com.api.porfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    private IPersonaService persoServ;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Persona per = new Persona ();
        usuarioService.save(usuario);
        System.out.println(usuario.getId());
        persoServ.crearPersona(per);
        System.out.println(per.getId_persona());
        per.setId_persona(usuario.getId());
        System.out.println(per.getId_persona());
        usuarioService.setIdPerRelacion(usuario.getId());
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        Usuario user = usuarioService.findUsuario(loginUsuario.getEmail());
        System.out.println(user.getId()); ///Obtengo el id del usuario logeado
        JwtDto jwtDto = new JwtDto(jwt, loginUsuario.getEmail(), user.getId());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
