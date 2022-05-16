package com.masudbappy.restfulwebservices.config;

import com.masudbappy.restfulwebservices.dto.EmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ErrorMailSenderConfig {
    @Autowired
    private EmailSetting emailSetting;
    /**
     * TaskExecutor bean for sendMail method ErrorMailSender
     *
     * @return executor {@link ThreadPoolTaskExecutor} instance for mail sending task
     */
    @Bean
    public TaskExecutor mailSendingTaskExecutor() {
        var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("mail-sending-executor-thread");
        executor.initialize();
        return executor;
    }

    /**
     * JavaMailSenderImpl bean for ErrorMailSender
     *
     * @return javaMailSender {@link JavaMailSenderImpl} instance
     */
    @Bean
    JavaMailSenderImpl getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailSetting.getSmtpServer());
        mailSender.setPort(Integer.parseInt(emailSetting.getSmtpPort()));
        return mailSender;
    }
}
