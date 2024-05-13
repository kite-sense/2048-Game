package Main;

public class Main {
    //目标：开局联网并开始玩，赢了或者输了就把时间传到对面
    public static Object lock =new Object();
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        mainThread.start();
    }
}
