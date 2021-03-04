package com.javarush.task;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class TestMail {


    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");

        Session session = Session.getDefaultInstance(props);
        //создаем сообщение
        MimeMessage message = new MimeMessage(session);
        String encodedBody = ("This is actual message df");
        message.setText(encodedBody);
        message.setHeader("Content-Type","UTF-8");
        message.setFrom("boomzin@gmail.com");


//устанавливаем тему письма
        message.setSubject("тестовое письмо!");


//добавляем текст письма
//        message.setText("<h1>Asta la vista, baby! русский текст<h1>");

//указываем получателя
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("ernest.aydinov@mvk.ru"));

//указываем дату отправления
        message.setSentDate(new Date());

        //логин и пароль gmail пользователя
        String userLogin = "boomzin";
        String userPassword = "Hl999j8C4";

//авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, userLogin, userPassword);

//отправляем сообщение:
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

    }
}
