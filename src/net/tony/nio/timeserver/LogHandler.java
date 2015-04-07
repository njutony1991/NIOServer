package net.tony.nio.timeserver;

import net.tony.nio.nioserver.Request;
import net.tony.nio.nioserver.event.EventAdapter;

import java.util.Date;

/**
 * 实现日至记录服务的事件处理器
 */
public class LogHandler extends EventAdapter {
    public LogHandler() {
    }

    public void onClosed(Request request) throws Exception {
        String log = new Date().toString() + " from " + request.getAddress().toString();
        System.out.println(log);
    }

    public void onError(String error) {
        System.out.println("Error: " + error);
    }
}
