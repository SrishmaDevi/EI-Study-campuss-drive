
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ChatRoom class represents a chat room with a list of messages and users.
 * It implements the ChatObserver interface to receive message updates.
 */
public class ChatRoom implements ChatObserver, Serializable {
    private String roomId;
    private List<Message> messages;
    private List<User> users;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public synchronized void addUser(User user) {
        users.add(user);
        System.out.println(user.getUsername() + " has joined the room " + roomId);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
        System.out.println(user.getUsername() + " has left the room " + roomId);
    }

    public synchronized void addMessage(Message message) {
        messages.add(message);
        notifyUsers(message);
        saveChatHistory();
    }

    @Override
    public void update(Message message) {
        addMessage(message);
    }

    private void notifyUsers(Message message) {
        for (User user : users) {
            System.out.println("Notify " + user.getUsername() + ": " + message.toString());
        }
    }

    public synchronized List<Message> getMessages() {
        return messages;
    }

    public synchronized List<User> getUsers() {
        return users;
    }

    public synchronized boolean isUserInRoom(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void saveChatHistory() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(roomId + ".ser"))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ChatRoom loadChatHistory(String roomId) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(roomId + ".ser"))) {
            return (ChatRoom) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ChatRoom(roomId);
        }
    }

    public static void deleteChatHistory(String roomId) {
        File file = new File(roomId + ".ser");
        if (file.exists()) {
            file.delete();
        }
    }
}
