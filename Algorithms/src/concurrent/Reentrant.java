package concurrent;

public class Reentrant {
    public static class Widget{
        public synchronized void doSomething(){

        }
    }
    public static class LoggingWidget extends Widget{
        public synchronized void doSomething(){
            System.out.println(toString()+":calling doSomething");
            super.doSomething();
        }
    }
    public static void main(String[] args){
        new LoggingWidget().doSomething();
    }
}
