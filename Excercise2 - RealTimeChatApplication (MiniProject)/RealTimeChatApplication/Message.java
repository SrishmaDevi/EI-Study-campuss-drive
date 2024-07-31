

import java.io.Serializable;
import java.util.Date;

/**
 * Message class represents a chat message with a username, content, and timestamp.
 */
public class Message implements Serializable {
    private String username;
    private String content;
    private Date timestamp;

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
        this.timestamp = new Date();
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + username + ": " + content;
    }
}
