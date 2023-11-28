import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Expression {
    private Identifier identifier;
    private Literal literal;

    public Object evaluate(String a, int b) {
        if (identifier != null) {
            return identifier.evaluate(a);
        } else if (literal != null) {
            return literal.evaluate();
        }
        return null;
    }
}
