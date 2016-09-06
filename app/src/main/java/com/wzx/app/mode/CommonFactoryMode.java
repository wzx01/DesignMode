package com.wzx.app.mode;

/**
 *普通工厂模式测试
 * Created by wzx001 on 2016/8/25.
 */
public class CommonFactoryMode {
    public static void main(String[] args){
       /* SimpleSendFactory factory = new SimpleSendFactory();
        Sender sender = factory.product("sms");
        sender.send();*/
       /* MultiSendFactory factory = new MultiSendFactory();
        Sender sender = factory.produceMail();
        sender.send();*/
        Sender sender = StaticSendFactory.produceMail();
        sender.send();
    }
}

 interface Sender{
    public void send();
}
 class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("EmailSender");
    }
}
 class MsgSender implements  Sender{

    @Override
    public void send() {
        System.out.println("MessageSender");
    }
}

/**
 * 简单工厂模式
 * 就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 */
 class SimpleSendFactory{
    public  Sender product(String type){
        if("email".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new MsgSender();
        }else{
            System.out.println("请输入正确的类型");
            return  null;
        }
    }
}

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
class MultiSendFactory{
    public  Sender produceMail(){
        return new MailSender();
    }

    public  Sender produceMsg(){
        return new MsgSender();
    }
}

/**
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */
class StaticSendFactory{
    public  static Sender produceMail(){
        return new MailSender();
    }

    public  static Sender produceMsg(){
        return new MsgSender();
    }
}