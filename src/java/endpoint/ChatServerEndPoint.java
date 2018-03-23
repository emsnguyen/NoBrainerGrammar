package endpoint;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author emsnguyen
 */
@ServerEndpoint("/endpoint")
public class ChatServerEndPoint {
    static Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void handleOpen(Session userSession) {
        users.add(userSession);
    }
    @OnClose
    public void handleClose(Session userSession) {
        users.remove(userSession);
    }
    @OnMessage
    public String onMessage(String message, Session session) throws IOException {
        String username = (String) session.getUserProperties().get("username");
        if (username == null) {
            session.getUserProperties().put("username", username);
            session.getBasicRemote().sendText(buildJsonData("System", "you are now conneccted as " + username));
        } else {
            Iterator<Session> iter = users.iterator();
            while (iter.hasNext()) {
                iter.next().getBasicRemote().sendText(buildJsonData(username, message));
            }
        }
        return null;
    }
    public String buildJsonData(String username, String message) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("message", username + ": " + message).build();
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.write(jsonObject);
        return stringWriter.toString();
    }
    
}
