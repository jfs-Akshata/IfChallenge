import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a literal value in an expression.
 * A literal is a fixed value in code, such as a number, string, or boolean.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Literal {
    private Object value;
    private String type;

    /**
     * Evaluates and returns the literal value.
     * As this class represents a literal, the evaluation simply returns the value itself.
     *
     * @return The literal value stored in this instance.
     */
    public Object evaluate() {
        return value;
    }
}
