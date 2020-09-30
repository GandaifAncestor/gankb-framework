package pers.gankb.base.concurrent.producerandconsumer.first;

/**
 * @description: 体验第一个生产者-消费者模型，中间消息实体类
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Message1 {

    private String title; // 标题
    private String content; // 内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
