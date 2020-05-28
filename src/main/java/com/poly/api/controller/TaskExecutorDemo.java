package com.poly.api.controller;

import org.springframework.core.task.TaskExecutor;

/**
 * @author Haitd on 05/26/2020.
 * @created 26/05/2020 - 2:40 PM
 * @project api
 */
public class TaskExecutorDemo {
    private class MessagePrinterTask implements Runnable {

        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(message);
        }

    }

    private TaskExecutor taskExecutor;

    public TaskExecutorDemo(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for (int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }
}
