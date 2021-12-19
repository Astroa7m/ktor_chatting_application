# ktor_chatting_application
Server/Client Chatting application that uses Ktor  websockets.
The application allows you to choose whether to chat in a group chat or privately to a specific connected user

**Note: Make sure to allow the Client.kt file to run in parallel in order to run multiple instances**

When you start the client the server asks for your name then let you know who is/are in the
server, and gives you the option to choose between group chat or private chat


# THE START

**1 Client**
![](https://i.imgur.com/GKzUu47.png)


**2 Clients**
![](https://i.imgur.com/WPGt4Wn.png)


# GROUP CHATTING

Let's say client 1 & 2 both chose option 1 (group chatting) the they will be chatting in a public channel anyone can join

![](https://i.imgur.com/qteiJAM.gif)


And if someone joined or left they'll be notified

![](https://i.imgur.com/LFwzVQL.gif)


# PRIVATE CHATTING

The server gives you the option to chat with anyone within the server privately.
Note that the private message will not intercept with the group chat unless you message
someone who's joined a group chat channel, and if so he'll be the only one who sees the message.

The server first list the connected users and append (in group chat) to their name if they are currently in GC channel

**3 client group chatting and 2 privately**

![](https://imgur.com/kPGTsM2.gif)



