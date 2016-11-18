package calc.controllers;

import calc.services.calculations.CalcService;
import calc.services.versions.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private CalcService calcService;

    @Autowired
    private VersionService versionService;

    @RequestMapping(value = "/hypotenuse", method = RequestMethod.POST)
    public Double calcHypotenuse(@RequestParam Map<String, String> map) {
        return calcService.calculate(map);
    }

    @RequestMapping("/version")
    public String sendVersion() {
        try {
            return versionService.getVersion();
        } catch (IOException e) {
            return null;
        }
    }
}
