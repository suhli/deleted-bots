package org.deleted.bots.entity;

import java.io.Serializable;

public class Sender implements Serializable {
    //私聊消息Sender信息
    private Long id;//QQ号
    private String nickname;//昵称
    private String remark;//备注
    //群消息Sender额外包含的信息
    private String memberName;//群名片
    private String permission;//发送者群权限
    private Group group;//群信息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
