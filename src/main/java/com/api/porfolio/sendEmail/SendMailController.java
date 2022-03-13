
package com.api.porfolio.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    @Autowired
    private SendMailService mailService;

    @RequestMapping(value = "/persona/sendMail", method = RequestMethod.POST)
    @PostMapping
    public String sendMail(@RequestBody MailForm form){

        String message = form.getMessage()+"\n\n Datos de contacto: " +
                "\nNombre: " + form.getName() + "\nE-mail: " + form.getEmail();

        mailService.sendMail(form.getEmail(), "maximilianovazquez88@gmail.com", "Mensaje del Porfolio", message);

        return "correo enviado";
    }
}
