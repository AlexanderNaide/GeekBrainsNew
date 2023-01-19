package ru.gb.Bootcamp.Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List <Subscriber> subscribers = new ArrayList<>();

    private String body;

    public String getBody() {
        return body;
    }

    public Document(String text){
        this.body = text;
    }

    public void addText(String text){
        this.body += text;
        notifySubscribers();
    }

    private void notifySubscribers(){
        for (Subscriber subscriber : subscribers) {
            subscriber.Notification(this);
        }
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
}
