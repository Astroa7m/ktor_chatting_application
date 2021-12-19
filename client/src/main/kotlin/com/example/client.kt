package com.example

import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
   val client = HttpClient(){
       install(WebSockets)
   }
    runBlocking {
        client.webSocket(method = HttpMethod.Get, host = "localhost", port = 8080, path = "/chat"){
            val outputJob = launch { getAndDisplayOutput() }
            val inputJob = launch { takeAndSendInput() }

            inputJob.join()
            outputJob.cancelAndJoin()
        }
    }
    client.close()
}

suspend fun DefaultClientWebSocketSession.getAndDisplayOutput() {
    try{
        for (frame in incoming){
            if(frame is Frame.Text)
                println(frame.readText())
        }
    }catch (e: Exception){
        println("Error occurred while receiving ${e.localizedMessage}")
        return
    }
}

suspend fun DefaultClientWebSocketSession.takeAndSendInput() {
    val name = readLine() ?: ""
    send(Frame.Text(name))
    while (true){
        val message = readLine() ?: ""
        try {
            send(message)
        }catch (e: Exception){
            print("Error occurred while sending ${e.localizedMessage}")
            return
        }
    }
}
