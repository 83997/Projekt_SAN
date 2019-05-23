package pl.san.scorestorage.adapter.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.san.scorestorage.adapter.rest.domain.TokenResponse;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.port.DeviceService;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/v1/token/generate", produces = APPLICATION_JSON_VALUE)
public class AuthenticationDeviceController {

  @Autowired
  private DeviceService deviceService;

  @GetMapping()
  public ResponseEntity<TokenResponse> createDevice(@RequestParam String name) {
    try {
      Device device = deviceService.createDevice(name);
      TokenResponse result = new TokenResponse(device.getToken().toString());
      return new ResponseEntity<>(result, OK);
    }catch (IllegalArgumentException e){
      return new ResponseEntity<>(CONFLICT);
    }
  }
}
