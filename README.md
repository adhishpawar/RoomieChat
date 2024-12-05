# RoomieChat - Real-Time Chat Application

**RoomieChat** is a real-time, room-based chat application built with **WebSocket**, **STOMP**, **SockJS**, and **MongoDB**. This project provides both backend and frontend functionality for seamless messaging.

## Features

- **Room-Based Messaging**: Create and join rooms for focused discussions.
- **Real-Time Updates**: Instant message exchange using WebSocket and STOMP.
- **MongoDB Integration**: Persistent storage for rooms and messages.
- **RESTful APIs**: Efficient endpoints for room management and message handling.
- **User Interface**: Simple UI for room management and messaging.

## Technologies Used

- **WebSocket, STOMP, SockJS**: Real-time bidirectional communication.
- **MongoDB**: Persistent chat data storage.
- **Spring Boot**: Backend development and API management.
- **HTML, CSS, JavaScript**: Responsive frontend interface.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/adhishpawar/RoomieChat.git
2. Set up MongoDB locally or use a cloud instance.

3. Build and run the Spring Boot application:
   ```bash
    mvn clean install
    mvn spring-boot:run

5. Access the application in your browser.(Working)    


## Future Scope
- **Multi-Room Management**: Implement user roles and room management features.
- **Private Messaging**: Add functionality for direct private messaging.
- **Enhanced UI/UX**: Improve user interface for better usability.
- **Authentication**: Secure room access with JWT-based authentication.
- **Scalability**: Enhance message handling for large user bases.
