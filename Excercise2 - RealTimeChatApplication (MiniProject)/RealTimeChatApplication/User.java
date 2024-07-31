

import java.io.Serializable;

/**
 * User class represents a user in the chat application with a username.
 */
public class User implements Serializable {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
