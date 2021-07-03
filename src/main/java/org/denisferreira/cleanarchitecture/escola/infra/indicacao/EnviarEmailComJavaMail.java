package org.denisferreira.cleanarchitecture.escola.infra.indicacao;

import org.denisferreira.cleanarchitecture.escola.application.indicacao.EnviarEmailIndicacao;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.Aluno;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EnviarEmailComJavaMail implements EnviarEmailIndicacao {
    private final Session session;

    public EnviarEmailComJavaMail(String username, String password) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    @Override
    public void enviarPara(Aluno indicado) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(indicado.getEmail()));
            message.setSubject("Mail Subject");

            String msg = "This is my first email using JavaMailer";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Fail to send mail");
        }
    }

}
