package pro.sky.hogwards.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hogwards.school.model.InfoDTO;
import pro.sky.hogwards.school.service.InfoService;

@RestController
public class InfoController {

    @Value("${app.env}")
    private String env;

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/appInfo")
    public ResponseEntity<InfoDTO> getAppInfo() {
        return ResponseEntity.ok(infoService.getAppInfo(env));
    }
}
