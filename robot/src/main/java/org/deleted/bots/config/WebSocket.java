package org.deleted.bots.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.deleted.bots.annotation.Configuration;
import org.deleted.bots.annotation.Plug;
import org.deleted.bots.core.MessageEventHandle;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 与mirai机器人的WebSocket链接在这里初始化
 */
@Configuration
public class WebSocket {

    public void init() {
        webSocketClient();
    }
    //用于websocket链接
    private String websocketUrl = "ws://"+System.getProperty("ip");

    //消息处理器
    private MessageEventHandle messageEventHandle = new MessageEventHandle();

    public WebSocketClient webSocketClient() {
        try {
            //获取插件类用于消息事件的响应
            Reflections reflections = new Reflections(System.getProperty("package"));
            Set<Class<?>> classes =  reflections.getTypesAnnotatedWith(Plug.class);
            //实例化所有的插件
            List<Object> miraiPlugs = new ArrayList<>();
            for(Class cls:classes){
                if(Modifier.isAbstract(cls.getModifiers())){//需要排除抽象类
                    continue;
                }
                Object obj =  cls.getDeclaredConstructor().newInstance();
                miraiPlugs.add(obj);
            }
            //开始进行WebSocket连接 监听Mirai的消息事件。
            WebSocketClient webSocketClient = new WebSocketClient(new URI(websocketUrl+"/message?sessionKey="+System.getProperty("sessionKey")),new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    System.out.println("[websocket] 连接成功");
                }
                @Override
                public void onMessage(String message) {
                    JSONObject messageJson = JSON.parseObject(message);
                    String type = (String) messageJson.get("type");
                    try {
                        if(type.equals("FriendMessage") || type.equals("TempMessage")){
                            messageEventHandle.privateMessageHandle(messageJson,miraiPlugs);
                        }else if(type.equals("GroupMessage")){
                            messageEventHandle.groupMessageHandle(messageJson,miraiPlugs);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("[websocket] 收到消息="+message);
                }
                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("[websocket] 退出连接");
                }

                @Override
                public void onError(Exception ex) {
                    System.out.println("[websocket] 连接错误={}"+ex.getMessage());
                }

            };
            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
