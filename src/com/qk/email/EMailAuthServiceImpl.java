package com.qk.email;


import com.qk.bean.User;
import com.qk.common.MD5;
import com.qk.common.Tools;
import com.qk.dao.DaoFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 邮箱认证服务的实现类
 */
public class EMailAuthServiceImpl implements EMailAuthService {
    public EMailSender sender = null;

    public EMailAuthServiceImpl() throws Exception {
        sender = new EMailSender("tangqianfeng820@gmail.com", "q67845287");
    }

    @Override
    public void sendAuthEMail(String email, User user) {

        String subject = "QuickKnowledge邮箱认证";
        String message = null;
        //获取邮件内容
        if (user != null) {
            message = user.getReal_name() + "，你好!\n" +
                    "你的账号已通过了QuickKnowledge的审核。\n" +
                    "你需要激活邮箱之后才能登录此网站。\n" +
                    "点击以下链接激活帐号。\n\n";
        } else {
            message = "你好!\n" +
                    "你的账号已通过了QuickKnowledge的审核。\n" +
                    "你需要激活邮箱之后才能登录此网站。\n" +
                    "点击以下链接激活帐号。\n\n";
        }

        //生成 认证地址
        String emailCode = MD5.encodeMD5(Tools.getNowDate());
        //存储认证地址
        user.setActive_code(emailCode);
        System.out.println(user.getId() + "    " + user.getActive_code());
        DaoFactory.userDao.update(user);
        String authUrl = "http://172.22.12.32:8080/man/emailCallBack.action?emailCode=" + emailCode;
        message += authUrl + "\n\n";
        message += "如果激活后不能登录此网站，请联系023-123456";
        //存储认证地址
//        registerUserMap.put(emailCode,user);
        //发送邮件
        sender.addTask(email, subject, message);
    }
}
