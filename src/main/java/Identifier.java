import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an identifier in an expression.
 * An identifier typically refers to a variable name within the context of an expression.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Identifier {
    private String name;

    /**
     * Evaluates the identifier to its corresponding value.
     * The method expects two possible variables 'a' and 'b', and returns their value based on the identifier's name.
     *
     * @param a The value associated with the identifier 'a'.
     * @param b The value associated with the identifier 'b'.
     * @return The value of the identifier, which can be either 'a' or 'b', or null if the identifier's name is neither.
     */
    public Object evaluate(Object a, Object b) {
        if ("a".equals(name)) {
            return a;
        } else if ("b".equals(name)) {
            return b;
        }
        return null;
    }
}
