import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Condition {
    private BinaryExpression binaryExpression;
    private LogicalExpression logicalExpression;

    public boolean evaluate(String a, int b) {
        if (binaryExpression != null) {
            return binaryExpression.evaluate(a, b);
        } else if (logicalExpression != null) {
            return logicalExpression.evaluate(a, b);
        }
        return false;
    }
}
