/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.vavedem.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import ro.vavedem.models.EmailContentModel;

/**
 *
 * @author bogdan.volosincu
 */
@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(EmailContentModel content) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" d MMM yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Context context = new Context();
        context.setVariable("nume", content.getSenderName());
        context.setVariable("replyEmail", content.getReplyEmail());
        context.setVariable("institutie", content.getInstitutionName());
        context.setVariable("adresaPetent", content.getSenderAddress());
        context.setVariable("adresaInstitutie", content.getInstitutionAddress());
        context.setVariable("telefon", content.getSenderPhone());
        context.setVariable("data", dtf.format(now));

        context.setVariable("documente", content.getDocuments());
        return templateEngine.process("mail", context);
    }

}
