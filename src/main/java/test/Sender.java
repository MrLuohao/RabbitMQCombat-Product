package test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * @Title: Sender
 * @Author Mr.罗
 * @Package test
 * @Date 2023/12/4 16:54
 * @description: 消息生产者
 */
public class Sender {
    public static void main(String[] args) {
        //1.创建spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-prodcut.xml");
        //2.从容器中获得rabbit模板对象
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        //3.发送消息
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("email", "1441432393@qq.com");
        rabbitTemplate.convertAndSend("msg.user", map);//msg.user为消息键
        //4.关闭spring容器
        context.close();
    }
}
