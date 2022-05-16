package com.masudbappy.restfulwebservices.handler;

import com.masudbappy.restfulwebservices.constant.CommonApiConstants;
import com.masudbappy.restfulwebservices.serviceImpl.MailSenderServiceImpl;
import com.masudbappy.restfulwebservices.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ErrorMailHandler {
    @Autowired
    private MailSenderServiceImpl mailSenderService;

    /**
     * Prepare alert mail and send
     * @param request ServerRequest instance containing messaging data
     * @author mahmudul.talukder@bjitgroup.com
     * @JIRA ticket-ref ECMG-10552
     */
    @Async("mailSendingTaskExecutor")
    public void sendMail(ServerRequest request, Throwable ex) {
        mailSenderService.sendMail(prepareMailSubject(CommonUtils.getRequestId(request)),
                prepareMailContent(ex));
    }

    /**
     * Prepare mail subject
     *
     * @param requestId requestId from ServerRequest
     * @return mail subject
     */
    private static String prepareMailSubject( String requestId) {
        return String.format(CommonApiConstants.KEY_EMAIL_SUBJECT_PATTERN, getServerIp(), requestId);
    }

    /**
     * Get server ip where Cabinet API is running
     *
     * @return serverIp
     */
    private static String getServerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return CommonApiConstants.EMPTY_STRING;
        }
    }

    /**
     * Prepare Email content
     *
     * @param ex {@link Throwable root cause exception
     * @return content
     */
    private static String prepareMailContent(Throwable ex) {
        var errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return String.format(CommonApiConstants.KEY_EMAIL_BODY_PATTERN, ex.getClass(),
                ex.getMessage(), ex.getLocalizedMessage() , errors);
    }
}
