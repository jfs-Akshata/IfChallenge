import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an expression that can be either an identifier or a literal.
 * An expression forms the fundamental part of a larger logical or arithmetic expression.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Expression {
    private Identifier identifier;
    private Literal literal;

    /**
     * Evaluates the expression based on whether it contains an identifier or a literal.
     *
     * @param a The value associated with the identifier 'a', if used in the expression.
     * @param b The value associated with the identifier 'b', if used in the expression.
     * @return The evaluated result of the expression, which can be an instance of any object.
     */
    public Object evaluate(Object a, Object b) {
        if (identifier != null) {
            return identifier.evaluate(a, b);
        } else if (literal != null) {
            return literal.evaluate();
        }
        return null;
    }

}
