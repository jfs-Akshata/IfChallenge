import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class BinaryExpression {
    private String operator;
    private Expression left;
    private Expression right;

    public boolean evaluate(String a, int b) {
        Object leftValue = left.evaluate(a, b);
        Object rightValue = right.evaluate(a, b);

        if ("==".equals(operator)) {
            return leftValue.equals(rightValue);
        } else if (">".equals(operator)) {
            return (int) leftValue > (int) rightValue;
        }
        // Add more binary operators if needed
        return false;
    }
}
