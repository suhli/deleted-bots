# deleted-bots

**deleted-bots**是什么？这答案是有待于被实现的。

就目前来说，它是一个「问答记录应用」。它记录QQ群中的问题和回答，并且展现于网页上。

## 功能

1. 记录指定QQ群内的所有「聊天讯息」，并识别出聊天讯息中的「问题」和「答案」（及其对应关系）。
2. 愉快的浏览界面。用户可以查阅所有聊天讯息和问答，管理员可以修改问答。

## 如何使用

运行一键安装脚本(并没有)。

## 配置文件

`dbots.conf`
```
[BOT]
QQ_ACCT
QQ_PASSWD
QGROUP_ID
[WEB]
HTTP_URL
ADMIN_NAME
ADMIN_PASSWD
```