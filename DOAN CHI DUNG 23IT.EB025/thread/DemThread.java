public class DemThread extends Thread{
    private Dem dem;
    private int incrementsPerThread;
    public DemThread(Dem dem,int incrementsPerThread){
        this.dem = dem;
        this.incrementsPerThread = incrementsPerThread;
    }
    @Override
    public void run() {
        for (int i = 0; i < incrementsPerThread; i++) {
            try {
                dem.increment();
            } catch(InterruptedException e) {throw new RuntimeException(e);
            }
        }
    }
}