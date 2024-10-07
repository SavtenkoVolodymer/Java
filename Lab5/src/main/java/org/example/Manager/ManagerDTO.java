package org.example.Manager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO {
    private int idManager;
    private String name;
    private String  DateOfBirth;
    private int password;

    public ManagerDTO(int idManager ,String name, String DateOfBirth, int password) {
        this.idManager = idManager;
        this.name = name;
        this.DateOfBirth = DateOfBirth;
        this.password = password;
    }

    @Override
    public String toString() {
        return idManager + " " + name + " " + DateOfBirth + " " + password;
    }
}
