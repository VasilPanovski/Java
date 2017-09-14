package designPatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {

    void update();
    void unsubscribe();
}

interface Observable {

    void notifyObservers();
    void scheduleDownTime(String message);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    String getScheduleMessage();
}

class User implements Observer {
    private String userName;
    private String emailAddress;
    private Observable observable;

    public User(String userName, String emailAddress, Observable observable) {
        this.userName = userName;
        this.emailAddress = emailAddress;

        this.observable = observable;
    }

    public String getUserName() {
        return this.userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        read();
        unsubscribe();
    }

    private void read() {
        System.out.println(this.getUserName() + " received:");
        System.out.println(this.observable.getScheduleMessage());
    }

    @Override
    public void unsubscribe() {
        this.observable.removeObserver(this);
    }

}

class Server implements Observable {
    private String message;
    List<Observer> observers;

    public Server() {
        this.observers = new ArrayList<>();
    }

    public String getScheduleMessage() {
        return this.message;
    }

    @Override
    public void scheduleDownTime(String message) {
        this.message = message;

        //TODO notify all observers
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> clonedObservers = new ArrayList<>(this.observers);

        for (Observer clonedObserver : clonedObservers) {
            clonedObserver.update();
        }
    }
}

public class ObserverPattern {

    public static void main(String[] args) {
        Observable server = new Server();

        Observer gosho = new User("Gosho", "gosho@abv.bg", server);
        Observer pesho = new User("Pesho", "pesho@abv.bg", server);
        // tosho wont receive a message becouse he isn't subscibe to a surver
        Observer tosho = new User("Tosho", "tosho@yahoo.com", null);

        server.addObserver(gosho);
        server.addObserver(pesho);

        server.scheduleDownTime("Our server will be unavailable on friday");

        // this message wont be received from anybody because they are unsubscribed
        server.scheduleDownTime("We are hosting a party!");

        Observer partyMan = new User("PartyMan", "letsparty@abv.bg", server);
        server.addObserver(partyMan);
        server.scheduleDownTime("We are hosting a party!");

        // this is how web hook works, like Watching in GitHub
    }
}
