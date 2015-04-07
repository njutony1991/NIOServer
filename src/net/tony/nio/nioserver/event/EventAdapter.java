package net.tony.nio.nioserver.event;

import net.tony.nio.nioserver.Request;
import net.tony.nio.nioserver.Response;

/**
 * <p>Title: 事件适配器</p>
 * @author tony
 * @version 1.0
 */

public abstract class EventAdapter implements ServerListener {
    public EventAdapter() {
    }
    public void onError(String error) {
    }
    public void onAccept() throws Exception {
    }
    public void onAccepted(Request request)  throws Exception {
    }
    public void onRead(Request request)  throws Exception {
    }
    public void onWrite(Request request, Response response)  throws Exception {
    }
    public void onClosed(Request request)  throws Exception{
    }
}
