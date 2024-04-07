
package restAssured.models.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestRegisterModel {
    private String email;
    private String password;

    public RequestRegisterModel(String email) {
        this.email = email;
    }
}
