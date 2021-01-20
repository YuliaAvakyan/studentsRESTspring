package studentsrestproj.demo.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreationEventHandler implements ApplicationListener<StudentCreationEvent> {
    private final Log log = LogFactory.getLog(getClass());
    private final SimpMessagingTemplate websocket;

    public CreationEventHandler(SimpMessagingTemplate websocket) {
        this.websocket = websocket;
    }

    @Override
    public void onApplicationEvent(StudentCreationEvent event) {
        log.info("Received spring custom event - " + event.getStudent());
        log.info("New student created Event");

        this.websocket.convertAndSend(
                "/topic/creation", event.getStudent());
    }
}