package org.example.Topic;

import lombok.*;
import org.example.Client.ClientDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {
    private String description;
    private String name;
    private ClientDTO id;

    @Override
    public String toString() {
        return "Topic: " + name + " " + description;
    }
}
