package net.tony.nio.nioserver;

import net.tony.nio.nioserver.event.ServerListener;

import java.util.ArrayList;

/**
 * <p>Title: 事件触发器</p>
 * @author tony
 * @version 1.0
 */
public class Notifier {
    private static ArrayList<ServerListener> listeners = null;
    private static Notifier instance = null;

    private Notifier() {
        listeners = new ArrayList<ServerListener>();
    }

    /**
     * 获取事件触发器（单例）
     * @return 事件触发器
     */
    public static synchronized Notifier getNotifier() {
        if (instance == null) {
            instance = new Notifier();
            return instance;
        }
        else return instance;
    }

    /**
     * 添加事件监听器
     * @param l 监听器
     */
    public void addListener(ServerListener l) {
        synchronized (listeners) {
            if (!listeners.contains(l))
                listeners.add(l);
        }
    }

    public void fireOnAccept() throws Exception {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onAccept();
    }

    public void fireOnAccepted(Request request) throws Exception {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onAccepted(request);
    }

    void fireOnRead(Request request) throws Exception {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onRead(request);

    }

    void fireOnWrite(Request request, Response response)  throws Exception  {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onWrite(request, response);

    }

    public void fireOnClosed(Request request) throws Exception {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onClosed(request);
    }

    public void fireOnError(String error) {
        for (int i = listeners.size() - 1; i >= 0; i--)
            listeners.get(i).onError(error);
    }
}
