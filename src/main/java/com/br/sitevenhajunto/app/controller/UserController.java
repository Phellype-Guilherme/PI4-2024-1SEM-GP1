package com.br.sitevenhajunto.app.controller;

import com.br.sitevenhajunto.domain.entitie.User;
import com.br.sitevenhajunto.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // nome do arquivo HTML (sem .html)
        return modelAndView;
    }


    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // nome do arquivo HTML (sem .html)
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password) {

        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // Credenciais válidas, redirecionar para a página principal
            modelAndView.setViewName("redirect:/home");
        } else {
            // Credenciais inválidas, retornar para a página de login com uma mensagem de erro
            modelAndView.setViewName("redirect:/login?error=true");
        }

        return modelAndView;
    }

    @RequestMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastro"); // nome do arquivo HTML (sem .html)
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public ModelAndView cadastrarUsuario(@RequestParam String name,
                                   @RequestParam String sobrenome,
                                   @RequestParam String dataNascimento,
                                   @RequestParam String email,
                                   @RequestParam String password) throws ParseException {

        ModelAndView modelAndView = new ModelAndView();

        DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
        formatUS.setLenient(false); // assim não aceita datas inválidas

        Date date = formatUS.parse(dataNascimento);

        User user = new User();
        user.setUsername(name);
        user.setSurname(sobrenome);
        user.setBirthDate(date);
        user.setEmail(email);
        user.setPassword(password);

        userService.createUser(user);

        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }
}
