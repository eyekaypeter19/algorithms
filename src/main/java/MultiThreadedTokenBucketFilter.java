//
//
//public class MultiThreadedTokenBucketFilter {
//    private long possibleTokens = 0;
//    private final int MAX_possibleTokens;
//    private final int ONE_SECOND = 1000;
//
//    public MultiThreadedTokenBucketFilter(int maxTokens) {
//
//        MAX_possibleTokens = maxTokens;
//        Thread dt = new Thread(() -> {
//            daemonThread();
//        });
//        dt.setDaemon(true);
//        dt.start()
//    }
//
//    private void daemonThread() {
//        while (true) {
//            synchronized (this) {
//                if (possibleTokens < MAX_possibleTokens) {
//                    possibleTokens++;
//                }
//                this.notify();
//            }
//            try {
//                Thread.sleep(ONE_SECOND);
//            } catch (InterruptedException InterruptedException) {
//            }
//        }
//    }
//
//    void getToken() throws InterruptedException {
//        synchronized(this) {
//            while (possibleTokens == 0){
//            this.wait();
//            }
//            possibleTokens --;
//        }
//    }
//}