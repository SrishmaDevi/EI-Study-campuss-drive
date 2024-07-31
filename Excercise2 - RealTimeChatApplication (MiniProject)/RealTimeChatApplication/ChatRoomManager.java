

import java.util.HashMap;
import java.util.Map;

/**
 * ChatRoomManager is a singleton class that manages all chat rooms.
 */
public class ChatRoomManager {
    private static ChatRoomManager instance;
    private Map<String, ChatRoom> chatRooms;

    private ChatRoomManager() {
        chatRooms = new HashMap<>();
    }

    public static synchronized ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
        }
        return instance;
    }

    public synchronized ChatRoom getChatRoom(String roomId) {
        return chatRooms.get(roomId);
    }

    public synchronized ChatRoom createChatRoom(String roomId) {
        ChatRoom chatRoom = ChatRoom.loadChatHistory(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }

    public synchronized void removeChatRoom(String roomId) {
        chatRooms.remove(roomId);
    }

    public synchronized Map<String, ChatRoom> getChatRooms() {
        return chatRooms;
    }
}
