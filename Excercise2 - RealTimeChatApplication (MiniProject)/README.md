===========================
Real-time Chat Application
===========================

Overview
========
This is a console-based real-time chat application that allows users to create chat rooms, join them, send messages, view messages, list active users, send private messages, and leave chat rooms. It demonstrates the use of Singleton, Observer, and Adapter design patterns.

Features
========
- Create chat rooms
- Join chat rooms
- Send messages in chat rooms
- View messages in chat rooms
- List active users in chat rooms
- Send private messages
- Leave chat rooms
- Persistent message history

Design Patterns Used
====================
- **Singleton**: Ensures only one instance of `ChatRoomManager`.
- **Observer**: Notifies users of new messages.
- **Adapter**: Simulated via console commands (real implementation would involve WebSockets).

Prerequisites
=============
- Java Development Kit (JDK) 8 or higher

Usage
=====
- **create**: Create a new chat room.
- **join**: Join an existing chat room.
- **send**: Send a message in a chat room.
- **view**: View messages in a chat room.
- **users**: View active users in a chat room.
- **private**: Send a private message to a user in a chat room.
- **leave**: Leave a chat room.
- **exit**: Exit the application and clean up chat histories.

Example
=======
.. code-block:: text

   Welcome to the Real-time Chat Application
   Enter command (create/join/send/view/users/private/leave/exit):
   create
   Enter room ID:
   Room1
   Chat room Room1 created.
   Enter command (create/join/send/view/users/private/leave/exit):
   join
   Enter room ID:
   Room1
   Enter your username:
   Alice
   Alice has joined the room Room1
   Enter command (create/join/send/view/users/private/leave/exit):
   send
   Enter room ID:
   Room1
   Enter your username:
   Alice
   Enter your message:
   Hello, everyone!
   Notify Alice: [Wed Jul 24 10:20:00 IST 2024] Alice: Hello, everyone!
   Enter command (create/join/send/view/users/private/leave/exit):
   view
   Enter room ID:
   Room1
   [Wed Jul 24 10:20:00 IST 2024] Alice: Hello, everyone!
   Enter command (create/join/send/view/users/private/leave/exit):
   users
   Enter room ID:
   Room1
   Alice
   Enter command (create/join/send/view/users/private/leave/exit):
   private
   Enter room ID:
   Room1
   Enter your username:
   Alice
   Enter recipient username:
   Bob
   Enter your private message:
   Hi Bob, how are you?
   Notify Alice: [Wed Jul 24 10:25:00 IST 2024] Alice: Private to Bob: Hi Bob, how are you?
   Enter command (create/join/send/view/users/private/leave/exit):
   leave
   Enter room ID:
   Room1
   Enter your username:
   Alice
   Alice has left the room Room1
   Enter command (create/join/send/view/users/private/leave/exit):
   exit
   Cleaning up chat histories...
   Exiting application.

Cleaning the Project
====================
To manually clean the project, you can delete the `.class` files and `.ser` files:

.. code-block:: sh

   find src -name "*.class" -type f -delete
   find src -name "*.ser" -type f -delete
