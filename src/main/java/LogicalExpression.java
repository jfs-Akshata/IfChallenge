import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a logical expression that can involve multiple conditions.
 * Supports logical operators like '&&' (AND) and '||' (OR) to combine conditions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogicalExpression {
    private String operator;
    private Condition[] conditions;

    /**
     * Evaluates the logical expression based on the specified operator and conditions.
     *
     * @param a The string value for variable 'a', if used in any of the conditions.
     * @param b The integer value for variable 'b', if used in any of the conditions.
     * @return The result of the logical expression evaluation, typically a boolean value.
     */
    public boolean evaluate(String a, int b) {

        if ("&&".equals(operator) && conditions != null) {
            for (Condition condition : conditions) {
                if (!condition.evaluate(a, b)) {
                    return false;
                }
            }
            return true;
        }

        else if ("||".equals(operator) && conditions != null) {
            for (Condition condition : conditions) {
                if (condition.evaluate(a, b)) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }
}
