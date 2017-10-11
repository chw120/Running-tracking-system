package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private int userId;
    @Column(unique = true)
    private String userName;
    private String userAddress;

    public UserInfo() {

    }

    @JsonCreator
    public UserInfo(@JsonProperty("username") String userName, @JsonProperty("address") String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }
}
