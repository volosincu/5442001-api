/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.vavedem.models;

import lombok.Data;

/**
 *
 * @author bogdan.volosincu
 */
@Data
public class EmailContentModel {

    String senderName;
    String senderAddress;
    String senderPhone;
    String replyEmail;

    String institutionName;
    String institutionAddress;

    String documents;

}
