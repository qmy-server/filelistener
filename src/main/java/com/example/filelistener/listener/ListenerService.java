package com.example.filelistener.listener;

import com.example.filelistener.websocket.MyWebSocket;
import org.springframework.stereotype.Service;

@Service
public class ListenerService {
    public void doSomething(String fileName) throws  Exception{
       // String imgLabel="<img src=\"localhost:8080/img/"+fileName+"\" />";
        //System.out.println(imgLabel);
        MyWebSocket.sendInfo(fileName);
    }
}
