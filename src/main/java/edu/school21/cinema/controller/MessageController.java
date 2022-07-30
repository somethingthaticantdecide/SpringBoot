package edu.school21.cinema.controller;

import edu.school21.cinema.model.OutputMessage;
import edu.school21.cinema.services.MessagesService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
public class MessageController {

    private final MessagesService messagesService;

    @Autowired
    public MessageController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(String message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        JSONObject obj = new JSONObject(message);
        if (!Objects.equals(obj.getString("text"), "")) {
            OutputMessage outputMessage = new OutputMessage(
                    obj.getString("author"),
                    obj.getString("text"),
                    time,
                    String.valueOf(obj.getInt("film")));
            Thread.sleep(1000);
            messagesService.add(outputMessage);
            return outputMessage;
        }
        return null;
    }
}