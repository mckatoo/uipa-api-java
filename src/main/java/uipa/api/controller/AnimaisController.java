package uipa.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnimaisController
 */

@RestController
@RequestMapping("api/animais")
public class AnimaisController {

  @GetMapping(path = "/")
  public String consultar() {
    return "animais";
  }

}
