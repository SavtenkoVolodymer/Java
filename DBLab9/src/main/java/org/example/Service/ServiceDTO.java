package org.example.Service;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private int name_id;
    private String creation_date;
    private String status;

    @Override
    public String toString() {
        return "Service: " + creation_date + " " + status;
    }
}
