package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {

    public enum HealthWarningLevel {
        HIGH, NORMAL, LOW
    }

    @Id
    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();
    private HealthWarningLevel healthWarningLevel;

    @ManyToOne(cascade=CascadeType.MERGE, targetEntity = UserInfo.class)
    private UserInfo userInfo;

    public RunningInformation() {

    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.runningId = runningId;
    }
}
