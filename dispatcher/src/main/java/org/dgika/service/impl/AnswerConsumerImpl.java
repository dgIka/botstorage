package org.dgika.service.impl;

import org.dgika.controller.UpdateController;
import org.dgika.service.AnswerConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static org.dgika.model.RabbitQueue.ANSWER_MESSAGE;

public class AnswerConsumerImpl implements AnswerConsumer {
    private UpdateController updateController;

    public AnswerConsumerImpl(UpdateController updateController) {
        this.updateController = updateController;
    }

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateController.setView(sendMessage);
    }
}
