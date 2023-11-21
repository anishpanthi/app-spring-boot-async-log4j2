package dev.app.logging;

import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@Log4j2
public class ApiService {

  Map<String, String> doGreetings() {
    var responseMap = Map.of("message", "Hello Spring fans!!!");
    log.info("{}", responseMap);
    return responseMap;
  }
}
