package bot.handlers;

import bot.keyboards.Keyboards;
import bot.TextMessage;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Order(value = 1)
public class LoginMessageHandler implements MessageHandler {
    @Override
    public SendMessage getMessage(Update update) {
        SendMessage message;
        message = new SendMessage();
        message.setChatId(String.valueOf(String.valueOf(update.getMessage().getChatId())));
        message.setText(TextMessage.loginMess);
        Keyboards.setButtons2(message);
        return message;
    }

    @Override
    public boolean canHandle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getText().equalsIgnoreCase(TextMessage.logging);
        }
        return false;
    }

}
