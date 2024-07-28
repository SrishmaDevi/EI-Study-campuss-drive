import java.util.ArrayList;
import java.util.List;

// Subject
class Newsletter {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String article) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(article);
        }
    }

    public void newArticle(String article) {
        System.out.println("New article published: " + article);
        notifySubscribers(article);
    }
}

// Observer
interface Subscriber {
    void update(String article);
}

// Concrete Observer
class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String article) {
        System.out.println("Sending email to " + email + " with new article: " + article);
    }
}

public class Main {
    public static void main(String[] args) {
        Newsletter newsletter = new Newsletter();

        Subscriber subscriber1 = new EmailSubscriber("subscriber1@example.com");
        Subscriber subscriber2 = new EmailSubscriber("subscriber2@example.com");

        newsletter.subscribe(subscriber1);
        newsletter.subscribe(subscriber2);

        newsletter.newArticle("Observer Pattern in Java");

        newsletter.unsubscribe(subscriber1);

        newsletter.newArticle("Another Article");
    }
}
