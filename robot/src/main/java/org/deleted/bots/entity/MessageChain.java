package org.deleted.bots.entity;

import java.io.Serializable;

public class MessageChain  implements Serializable {
    //最重要的type属性
    private String type;
    //Source 属性
    private String id;
    //发送时间
    private String time;
    //Plain 属性
    private String text;
    //Face 属性
    private String faceId;
    //群消息中被@的人
    private String target;
    //表情名
    private String name;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
