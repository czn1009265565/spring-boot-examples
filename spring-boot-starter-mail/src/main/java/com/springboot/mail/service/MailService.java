package com.springboot.mail.service;

/**
 * @author: zenan
 * @date: 2021/4/7
 */
public interface MailService {
    /**
     * 发送文本邮件
     * @param to receiver
     * @param subject subject
     * @param content content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html邮件
     * @param to receiver
     * @param subject subject
     * @param content content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to receiver
     * @param subject subject
     * @param content content
     * @param filePath 附件全路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
