package com.sdy.zookeeper.example;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author: sundy
 * @date: 2020/12/24 14:20
 * @description:
 */
public class DataMonitor implements Watcher, StatCallback {
    ZooKeeper zk;

    String znode;

    Watcher chainedWatcher;

    boolean dead;

    DataMonitorListener listener;

    byte[] prevData;

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;
        // Get things started by checking if the node exists. We are going
        // to be completely event driven
        zk.exists(znode, true, this, null);
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

    public interface DataMonitorListener {

        /**
         * The existence status of the node has changed.
         */
        void exists(byte[] data);

        /**
         * The ZooKeeper session is no longer valid.
         *
         * @param rc the ZooKeeper reason code
         */
        void closing(int rc);
    }
}
