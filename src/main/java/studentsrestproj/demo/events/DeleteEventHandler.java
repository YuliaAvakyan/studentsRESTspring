package studentsrestproj.demo.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeleteEventHandler implements ApplicationListener<StudentDeleteEvent> {
    private final Log log = LogFactory.getLog(getClass());
    private final SimpMessagingTemplate websocket;

    public DeleteEventHandler(SimpMessagingTemplate websocket) {
        this.websocket = websocket;
    }

    @Override
    public void onApplicationEvent(StudentDeleteEvent event) {
        log.info("Received spring custom event - " + event.getStudentId());
        log.info("Student deleted Event");

        this.websocket.convertAndSend(
                "/topic/delete", event.getStudentId());
    }
}