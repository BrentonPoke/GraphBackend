package graph.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class Events {
    @Id
    @GeneratedValue
    private Long eventId;

    private String what;

    private String where;

    private LocalDateTime start, end;
    
    public Events(String what, String where, LocalDateTime start, LocalDateTime end) {
        this.what = what;
        this.where = where;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("what",what).put("where",where)
            .put("start",start.format(DateTimeFormatter.ISO_DATE_TIME))
        .put("end",end.format(DateTimeFormatter.ISO_DATE_TIME));
        return json.toString();
    }
}
