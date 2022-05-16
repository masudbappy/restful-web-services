package com.masudbappy.restfulwebservices.serviceImpl;

import com.masudbappy.restfulwebservices.dto.EmailSetting;
import com.masudbappy.restfulwebservices.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSenderServiceImpl implements MailSenderService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private EmailSetting emailSetting;

    @Override
    public void sendMail(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailSetting.getTo());
        message.setFrom(emailSetting.getFrom());
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }
}
