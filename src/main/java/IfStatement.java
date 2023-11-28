import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class IfStatement {
    private String type;
    private Condition condition;
    private Literal consequent; // Can be Literal or another IfStatement
    private Object[] alternates;

    public boolean evaluate(String a, int b) {
        if (condition != null) {
            return condition.evaluate(a, b);
        }
        return false;
    }
}
