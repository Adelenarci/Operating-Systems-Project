import java.util.concurrent.Semaphore;
class ReadWriteLock{
    private Semaphore  S = new Semaphore(1);
    int reader_count = 0;

    public synchronized void readLock() {
        if(reader_count == 0) {
            S.acquire();
        }
        reader_count++;
    }
    public void writeLock() {
        S.acquire();
    }
    public synchronized void readUnLock()  {
        reader_count--;
        if(reader_count == 0) {
            S.release();
        }
    }
    public void writeUnLock() {
        S.release();
    }
}


