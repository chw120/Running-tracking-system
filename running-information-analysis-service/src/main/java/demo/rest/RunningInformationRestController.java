package demo.rest;

import demo.domain.RunningInformation;
import demo.model.RunningInformationDTO;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RunningInformationRestController {

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController(RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<RunningInformation> upload(@RequestBody List<RunningInformation> runningInformations) {
        Random random = new Random();
        for(RunningInformation runningInformation : runningInformations) {
            int heartRate = random.nextInt(200 - 60 +1) + 60;
            runningInformation.setHeartRate(heartRate);
            if(heartRate >= 60 && heartRate <= 75) {
                runningInformation.setHealthWarningLevel(RunningInformation.HealthWarningLevel.LOW);
            } else if(heartRate <= 120) {
                runningInformation.setHealthWarningLevel(RunningInformation.HealthWarningLevel.NORMAL);
            } else {
                runningInformation.setHealthWarningLevel(RunningInformation.HealthWarningLevel.HIGH);
            }
        }
        return this.runningInformationService.saveAllRunningInformation(runningInformations);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public List<RunningInformationDTO> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Page<RunningInformation> runningInformations = this.runningInformationService.findAll(new PageRequest(page, size, Sort.Direction.DESC, "healthWarningLevel"));
        List<RunningInformationDTO> res = new ArrayList<RunningInformationDTO>();
        for(RunningInformation ri : runningInformations) {
            res.add(new RunningInformationDTO(ri.getRunningId(), ri.getTotalRunningTime(), ri.getHeartRate(), ri.getUserInfo().getUserId(), ri.getUserInfo().getUserName(), ri.getUserInfo().getUserAddress(), ri.getHealthWarningLevel()));
        }
        return res;
    }

    @RequestMapping(value = "/runningInfo/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByRunningId(String runningId) {
        this.runningInformationService.deleteByRunningId(runningId);
    }
}