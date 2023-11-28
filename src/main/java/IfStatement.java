import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an 'if' statement in a logical expression.
 * This class allows the representation of an if-else-if-else structure through conditions and alternates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class IfStatement {
    private Condition condition;
    private Literal consequent;
    private IfStatement[] alternates;

    /**
     * Evaluates the 'if' statement based on the provided condition and alternates.
     * It follows a standard if-else-if-else logic flow.
     *
     * @param a The string value for variable 'a', if used in the condition.
     * @param b The integer value for variable 'b', if used in the condition.
     * @return The result of the 'if' statement evaluation, typically a boolean.
     */
    public boolean evaluate(String a, int b) {
        if (condition != null && condition.evaluate(a, b)) {
            return (Boolean) consequent.evaluate();
        } else if (alternates != null) {
            for (IfStatement alternate : alternates) {
                // Each alternate is an independent if-else block
                if (alternate.condition == null || alternate.condition.evaluate(a, b)) {
                    return (Boolean) alternate.consequent.evaluate();
                }
            }
        }

        return false; // Default return false if none of the conditions are met
    }
}