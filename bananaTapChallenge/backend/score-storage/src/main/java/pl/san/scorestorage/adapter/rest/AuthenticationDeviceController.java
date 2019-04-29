package pl.san.scorestorage.adapter.rest;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import pl.san.scorestorage.adapter.rest.domain.TokenResponse;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.port.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/token/generate", produces = APPLICATION_JSON_VALUE)
public class AuthenticationDeviceController {

  @Autowired
  private DeviceService deviceService;

  @GetMapping()
  public ResponseEntity<TokenResponse> createDevice() {
    Device device = deviceService.createDevice();
    TokenResponse result = new TokenResponse(device.getToken().toString());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
