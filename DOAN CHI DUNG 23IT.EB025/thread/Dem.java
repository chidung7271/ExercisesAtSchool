public class Dem {
    private int count = 0; //biến đếm
    public synchronized void increment() throws InterruptedException //sử dụng synchronized để ngăn các thread vào cùng 1 lúc - cho từng thread vào
    {
        count++; //khi dùng increment count+1
        System.out.println(" " + count + " "); // in ra count đã được cộng
        Thread.sleep(1000);//cho thread vừa vào nghỉ trong 1s
    }
    public int getCount() {
        return count;
    }
}

