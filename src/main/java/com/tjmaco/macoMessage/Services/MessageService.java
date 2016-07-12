package com.tjmaco.macoMessage.Services;

/**
 * Created by thomasmaco on 11/27/15.
 */

import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public static final String ACCOUNT_SID = "ACc4bde2171311053fc5728ed15c4921d4";
    public static final String AUTH_TOKEN = "";

    public static String sendMessage(String phoneNumber, String messageBody) throws TwilioRestException {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        if (isNumeric(phoneNumber)) {
            if (phoneNumber.indexOf("1") != 0){
                phoneNumber = "1"+phoneNumber;
            }
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("From", "+15136571353"));
            params.add(new BasicNameValuePair("To", "+" + phoneNumber));
            params.add(new BasicNameValuePair("Body", messageBody + " !Do not reply back to this message!"));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            return message.getSid();
        }
        return "Phone number was not a number.";
    }


    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

}
