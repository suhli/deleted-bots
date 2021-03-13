package org.deleted.bots.plug;

import org.deleted.bots.core.Mirai;
import org.deleted.bots.core.MiraiPlug;
import org.deleted.bots.entity.GroupMessageEvent;
import org.deleted.bots.entity.PrivateMessageEvent;

public class DemoPlug extends MiraiPlug {

    private boolean start = false;
    @Override
    public boolean onPrivateMessage(Mirai mirai, PrivateMessageEvent event) throws Exception{
        String message = event.getRawMessage();
        if (message.equals("开始复读")){
            start = true;
            return MESSAGE_IGNORE;
        }else if(message.equals("停止复读")){
            start = false;
            return MESSAGE_IGNORE;
        }
        if(start) {
            mirai.sendPrivateMsg(event.getUserId(),event.getMessageChain());
           // mirai.sendPrivateMsg(event.getUserId(),event.getRawMessage());
        }
        return MESSAGE_IGNORE;
    }

    @Override
    public boolean onGroupMessage(Mirai mirai, GroupMessageEvent event) throws Exception {
        String message = event.getRawMessage();
        if (message.equals("开始复读")){
            start = true;
            return MESSAGE_IGNORE;
        }else if(message.equals("停止复读")){
            start = false;
            return MESSAGE_IGNORE;
        }
        if(start) {
            mirai.SendGroupMSg(event.getGroupId(),event.getMessageChain());
            // mirai.sendPrivateMsg(event.getUserId(),event.getRawMessage());
        }
        return MESSAGE_IGNORE;
    }

    @Override
    public boolean onTempMessage(Mirai mirai, PrivateMessageEvent event) {
        return MESSAGE_IGNORE;
    }
}
