package pro.sky.hogwards.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.hogwards.school.model.InfoDTO;

@Service
public class InfoService {

    Logger logger = LoggerFactory.getLogger(InfoService.class);
    public InfoDTO getAppInfo(String env) {
        logger.info("Getting app info with key: {}", env);
        return new InfoDTO(env);
    }
}
