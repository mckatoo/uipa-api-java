package uipa.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StatusController
 */

@RestController
@RequestMapping("api/status")

public class StatusController {

  @GetMapping(path = "/")
  public String check() {
    return "online";
  }
}
