package edu.school21.cinema.services;

import edu.school21.cinema.model.OutputMessage;
import edu.school21.cinema.repositories.MessagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;

    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public void add(OutputMessage outputMessage) {
        messagesRepository.save(outputMessage);
    }

    public List<OutputMessage> getMessagesByFilmId(String id) {
        return messagesRepository.findAllByFilm(id);
    }
}
