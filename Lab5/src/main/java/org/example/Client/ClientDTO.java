package org.example.Client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO {
    private int idClient;
    private String name;
    private String DateOfBirth;
    private int password;


    public ClientDTO(int idClient, String name, String DateOfBirth , int password) {
        this.idClient = idClient;
        this.name = name;
        this.DateOfBirth = DateOfBirth;
        this.password = password;
    }
    @Override
    public String toString() {
        return idClient + " " + name + " " + DateOfBirth + " " + password;
    }
}
