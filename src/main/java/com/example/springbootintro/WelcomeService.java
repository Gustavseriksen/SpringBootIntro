package com.example.springbootintro;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WelcomeService {
    private final  WelcomeRepository welcomeRepository;

    public WelcomeService(WelcomeRepository welcomeRepository) {
        this.welcomeRepository = welcomeRepository;
    }

    public List<Message> getAllMessages() {
        return welcomeRepository.getAllMessages();
    }

    public Message findMessageById(int id, String caps) {
        Message message = welcomeRepository.findMessageById(id);
        if (caps != null && caps.equals("yes")) {
            return new Message(message.getId(), message.getText().toUpperCase());
        }
        return message;
    }

}
