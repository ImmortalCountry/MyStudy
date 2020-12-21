package com.sdy.designpatterns.singleton;

/**
 * @author: sundy
 * @date: 2020/12/21 18:17
 * @description: 进程间唯一
 */
public class ProgrammingSingleton {
    private static ProgrammingSingleton instance;
    private static SharedObjectStorage storage = FileSharedObjectStorage(/*入参省略，比如文件地址*/);

    private static SharedObjectStorage FileSharedObjectStorage() {
        return null;
    }

    private static DistributedLock lock = new DistributedLock();

    private ProgrammingSingleton() {
    }

    public synchronized static ProgrammingSingleton getInstance() {
        if (instance == null) {
            lock.lock();
            instance = storage.load(ProgrammingSingleton.class);
        }
        return instance;
    }

    public synchronized void freeInstance() {
        storage.save(this, ProgrammingSingleton.class);
        instance = null;
        //释放对象
        lock.unlock();
    }

    private static class DistributedLock {
        // 分布式锁
        public void lock() {

        }

        public void unlock() {

        }
    }

    private static class SharedObjectStorage {
        public ProgrammingSingleton load(Class<ProgrammingSingleton> programmingSingletonClass) {
            return null;
        }

        public void save(ProgrammingSingleton programmingSingleton, Class<ProgrammingSingleton> programmingSingletonClass) {

        }
    }
}
