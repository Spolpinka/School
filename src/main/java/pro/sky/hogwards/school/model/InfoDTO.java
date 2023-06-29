package pro.sky.hogwards.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {
    private String appName = "hogwarts-school";

    private String appVersion = "0.0.1";

    private String appEnvironment;

    public InfoDTO(String appEnvironment) {
        this.appEnvironment = appEnvironment;
    }
}
