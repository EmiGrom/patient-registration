import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor

public class Patient {
    private String name;
    private String surname;
    private String pesel;
    private double price;
    private String coronavirus;
}