import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogicalExpression {
    private String operator;
    private Condition[] conditions;

    public boolean evaluate(String a, int b) {
        if ("&&".equals(operator)) {
            for (Condition condition : conditions) {
                if (!condition.evaluate(a, b)) {
                    return false;
                }
            }
            return true;
        }
        // Add more logical operators if needed
        return false;
    }
}
