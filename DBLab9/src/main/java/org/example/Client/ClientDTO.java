package org.example.Client;

import lombok.*;
import org.example.Service.ServiceDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private int id;
    private String email;
    private String name;
    private ServiceDTO name_id;

    @Override
    public String toString() {
        return "Client: " + name + " " + email;
    }
}
