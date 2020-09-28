package p2.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Events {
    @Id
    @GeneratedValue
    private Long eventId;

    private String what;

    private String where;

    private String when;

    public Events(String what, String where, String when) {
        this.what = what;
        this.where = where;
        this.when = when;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("what",what).put("where",where).put("when",when);
        return json.toString();
    }
}
