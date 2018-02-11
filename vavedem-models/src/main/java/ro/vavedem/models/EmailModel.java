package ro.vavedem.models;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author CoruptiaUcide
 */
@Data
public class EmailModel {


    @NotNull
    private String from;
    @NotNull
    private String to;
    @NotNull
    private String subject;
    @NotNull
    private EmailContentModel content;

    private String formular;


}
