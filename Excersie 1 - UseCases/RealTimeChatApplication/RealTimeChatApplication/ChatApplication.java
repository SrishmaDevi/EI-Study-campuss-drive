package RealTimeChatApplication;

import java.util.Scanner;

/**
 * Main class for the chat application providing a console interface for user interaction.
 */
public class ChatApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static ChatRoomManager chatRoomManager = ChatRoomManager.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to the Real-time Chat Application");

        while (true) {
            System.out.println("Enter command (create/join/send/view/users/private/leave/exit):");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "create":
                    createChatRoom();
                    break;
                case "join":
                    joinChatRoom();
                    break;
                case "send":
                    sendMessage();
                    break;
                case "view":
                    viewMessages();
                    break;
                case "users":
                    viewUsers();
                    break;
                case "private":
                    sendPrivateMessage();
                    break;
                case "leave":
                    leaveChatRoom();
                    break;
                case "exit":
                    cleanUp();
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static void createChatRoom() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        chatRoomManager.createChatRoom(roomId);
        System.out.println("Chat room " + roomId + " created.");
    }

    private static void joinChatRoom() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        User user = new User(username);
        chatRoom.addUser(user);
    }

    private static void sendMessage() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        if (!chatRoom.isUserInRoom(username)) {
            System.out.println("User " + username + " is not part of the chat room " + roomId + ". Please join the room first.");
            return;
        }
        System.out.println("Enter your message:");
        String content = scanner.nextLine();
        Message message = new Message(username, content);
        chatRoom.addMessage(message);
    }

    private static void viewMessages() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        for (Message message : chatRoom.getMessages()) {
            System.out.println(message.toString());
        }
    }

    private static void viewUsers() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        for (User user : chatRoom.getUsers()) {
            System.out.println(user.getUsername());
        }
    }

    private static void sendPrivateMessage() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        System.out.println("Enter your username:");
        String fromUsername = scanner.nextLine();
        if (!chatRoom.isUserInRoom(fromUsername)) {
            System.out.println("User " + fromUsername + " is not part of the chat room " + roomId + ". Please join the room first.");
            return;
        }
        System.out.println("Enter recipient username:");
        String toUsername = scanner.nextLine();
        if (!chatRoom.isUserInRoom(toUsername)) {
            System.out.println("User " + toUsername + " is not part of the chat room " + roomId + ". Cannot send private message.");
            return;
        }
        System.out.println("Enter your private message:");
        String content = scanner.nextLine();
        Message message = new Message(fromUsername, "Private to " + toUsername + ": " + content);
        chatRoom.addMessage(message);
    }

    private static void leaveChatRoom() {
        System.out.println("Enter room ID:");
        String roomId = scanner.nextLine();
        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
        if (chatRoom == null) {
            System.out.println("Chat room not found.");
            return;
        }
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        User user = new User(username);
        chatRoom.removeUser(user);
    }

    private static void cleanUp() {
        // Cleanup logic, like deleting serialized files
        System.out.println("Cleaning up chat histories...");
        for (String roomId : chatRoomManager.getChatRooms().keySet()) {
            ChatRoom.deleteChatHistory(roomId);
        }
    }
}
