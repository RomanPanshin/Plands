//package com.plands.site.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    public void sendSimpleMessage(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("team@plands.ru");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//    }
//
//    public void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//        helper.setFrom("team@plands.ru");
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(htmlBody, true);
//        emailSender.send(message);
//    }
//
//    public void sendGreetingEmail(String to, String playerName) throws MessagingException, IOException {
//        // Load the subject from file
//        String subject = new String(Files.readAllBytes(Paths.get(new ClassPathResource("templates/email-subject.txt").getURI())), StandardCharsets.UTF_8);
//
//        // Create context for Thymeleaf template
//        Context context = new Context();
//        context.setVariable("playerName", playerName);
//
//        // Process the template with context variables
//        String htmlContent = templateEngine.process("greeting-email", context);
//
//        sendHtmlMessage(to, subject, htmlContent);
//    }
//}
