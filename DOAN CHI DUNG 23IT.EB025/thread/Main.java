public class Main {
    public static void main(String[] args) {
        Dem dem = new Dem();
        int numThreads = 6; // số thread bạn muốn chạy
        int incrementsPerThread = 5; // mỗi thread chạy từ 0 đến incrementsPerThread rồi ngỏm
        DemThread[] threads = new DemThread[numThreads]; // tạo list thread tương ứng
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new DemThread(dem, incrementsPerThread);
            threads[i].start();
        }
        try {
            for (DemThread thread: threads) {
                thread.join(); //thread phải chạy hết thì mới đến thread khác
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
