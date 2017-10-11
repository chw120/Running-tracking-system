package demo.model;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import lombok.Data;

import javax.persistence.Id;

@Data
public class RunningInformationDTO {
    public enum HealthWarningLevel {
        HIGH, NORMAL, LOW
    }

    private String runningId;
    private double totalRunningTime;
    private int heartRate = 0;
    private int userId;
    private String userName;
    private String userAddress;
    private RunningInformation.HealthWarningLevel healthWarningLevel;

    public RunningInformationDTO() {
    }

    public RunningInformationDTO(String runningId) {
        this.runningId = runningId;
    }

    public RunningInformationDTO(String runningId, double totalRunningTime, int heartRate, int userId, String userName, String userAddress, RunningInformation.HealthWarningLevel healthWarningLevel) {
        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = heartRate;
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.healthWarningLevel = healthWarningLevel;
    }
}
