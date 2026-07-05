package data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

import java.io.File;
public class UserData {
    public static UserData getUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            return mapper.readValue(new File( System.getProperty("user.dir") + "\\src\\testdata\\data\\User.json"), UserData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("admin")
    private String admin;

    @JsonProperty("employee")
    private String employee;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public String getEmployee() {
        return employee;
    }

    public String getAdmin() {
        return admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
