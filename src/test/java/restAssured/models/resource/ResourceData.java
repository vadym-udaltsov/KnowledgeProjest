
package restAssured.models.resource;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceData {
    private String color;
    private Integer id;
    private String name;
    private String pantone_value;
    private Integer year;
}
