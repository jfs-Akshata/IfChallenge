import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Identifier {
    private String name;
    private String type;

    public Object evaluate(Object value) {
        // Implement logic to get the value of the variable by name and handle different types
        if (name.equals("a") && "string".equals(type)) {
            return (String) value;
        } else if (name.equals("b") && "int".equals(type)) {
            return (Integer) value;
        }
        // Add more cases for other variables and types if needed
        throw new IllegalArgumentException("Unknown variable or type: " + name + " (" + type + ")");
    }
}
