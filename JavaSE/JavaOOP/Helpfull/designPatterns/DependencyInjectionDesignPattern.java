package designPatterns;

interface NotificationService {

    void sendMessage(String sendTo, String message);
}

interface Provider {
    String getProvider();
}

class TwitterService implements NotificationService {

    @Override
    public void sendMessage(String sendTo, String message) {
        System.out.println(sendTo + " received");
        System.out.println(message);
    }
}

class TwitterWrapper {

    NotificationService service;
    //Provider provider;

    // this way we can make dependency injection without library
    public TwitterWrapper() {
        this(new TwitterService());
    }

    public TwitterWrapper(NotificationService service) {
        this.service = service;
       // this.provider = provider;
    }

    public void processNotification(String sendTo, String message) {
  //      System.out.println("Provider: " + this.provider.getProvider());
        this.service.sendMessage(sendTo, message);
    }
}

class GoogleProvider implements Provider {

    @Override
    public String getProvider() {
        return "Google";
    }
}

public class DependencyInjectionDesignPattern {

    public static void main(String[] args) {

        TwitterWrapper twitter = new TwitterWrapper();
        twitter.processNotification("SoftUni", "Hallo");

    }
}
