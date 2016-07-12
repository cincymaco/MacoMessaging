package com.tjmaco.macoMessage.Controllers;

import com.tjmaco.macoMessage.Services.MessageService;

import com.twilio.sdk.TwilioRestException;

import org.json.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thomasmaco on 11/27/15.
 */

@RestController
public class MessageController {

    @RequestMapping(value = "/message/send", method = RequestMethod.POST)
    public static String sendMessage(@RequestBody String message) throws TwilioRestException {
        String phoneNumber;
        String body;
        try {
            JSONObject messageObject  = new JSONObject(message);
            phoneNumber = messageObject.getString("phoneNumber");
            body = messageObject.getString("body");
        } catch (JSONException e) {
            return "Massage failed to send";
        }

        return MessageService.sendMessage(phoneNumber,body);
    }
}
