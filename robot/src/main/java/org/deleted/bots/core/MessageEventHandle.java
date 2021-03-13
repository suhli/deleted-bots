package org.deleted.bots.core;

import com.alibaba.fastjson.JSONObject;
import org.deleted.bots.entity.GroupMessageEvent;
import org.deleted.bots.entity.PrivateMessageEvent;
import org.deleted.bots.util.MessageUtil;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 处理有关群消息的事件触发
 */
public class MessageEventHandle {

    private Mirai mirai = new Mirai();

    public void groupMessageHandle(JSONObject message, List<Object> miraiPlugs) throws Exception {
        GroupMessageEvent messageEvent = MessageUtil.GmessageEventAssemble(message);
        Class cls = MiraiPlug.class;
        boolean flag = true;
        for(Object obj : miraiPlugs){
            if(!flag) return;
            Method method  = cls.getMethod("onGroupMessage",Mirai.class, GroupMessageEvent.class);
            flag = (boolean) method.invoke(obj,mirai,messageEvent);
        }

    }

    public void privateMessageHandle(JSONObject message, List<Object> miraiPlugs) throws Exception {
        PrivateMessageEvent messageEvent = MessageUtil.PmessageEventAssemble(message);
        Class cls = MiraiPlug.class;
        boolean flag = true;
        for(Object obj : miraiPlugs){
            if(!flag) return;
            Method method  = cls.getMethod("onPrivateMessage",Mirai.class, PrivateMessageEvent.class);
            flag = (boolean) method.invoke(obj,mirai,messageEvent);
        }
    }


}
