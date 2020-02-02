//package servlet;
//// Author: Arthur
//// date: 2019/12/19  15:34
//
//import dao.mail;
//import dao.mailUnitl;
//
//public class testmail {
//    public static void main(String[] args) throws Exception {
//        mail mail = new mail();
//        mail.setHost("smtp.qq.com"); // 设置邮件服务器,如果不用QQ邮箱的,自己找找看相关的
//        mail.setPortNumber("465"); // 设置邮件服务器端口号,默认25
//        mail.setSender("1369610671@qq.com"); // 发送人
//        mail.setName("none"); // 发送人昵称
//        mail.setReceiver("2801609142@qq.com"); // 接收人
//        mail.setUsername("1369610671@qq.com"); // 登录账号,一般都是和邮箱名一样
//        mail.setPassword("rnnzdpqhotxzjgjc"); // QQ邮箱登录第三方客户端时,密码框请输入“授权码”进行验证。其他的密码具体查看邮件服务器的说明
//        mail.setSubject("这是标题");
//        mail.setMessage("收到请回复");
//        if (new mailUnitl().send(mail)) {
//            System.out.println("发送成功");
//        } else {
//            System.out.println("发送失败");
//        }
//}}
//
