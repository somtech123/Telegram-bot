package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        String command = update.getMessage().getText();
        if (command.equals("/run")){
            String message = "running now";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
            }catch (TelegramApiException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "Somtech102Bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5582095510:AAF2X1FdtAz5eZ1anjpqT8c2mOIR9Im9V4w";
    }
}
