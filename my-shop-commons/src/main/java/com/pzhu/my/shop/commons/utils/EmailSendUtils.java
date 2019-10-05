/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.utils
 * @ClassName: EmailSendUtils
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:30
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:30
 * @description:
 */
public class EmailSendUtils {

    @Autowired
    private Email email;

    public void send(String subject, String msg, String... to) throws EmailException {
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }
}
