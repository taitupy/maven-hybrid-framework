package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private String admin ;
    private String employee;
    private String username;
    private String password;

    public static UserInfo getUserData(){
        return new UserInfo();
    }
}
