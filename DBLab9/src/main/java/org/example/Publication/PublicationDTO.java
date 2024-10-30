package org.example.Publication;


import lombok.*;
import org.example.Topic.TopicDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {
    private int title_id;
    private String topics;
    private String text;
    private TopicDTO description;

    @Override
    public String toString() {
        return "Publication: " + topics + " " + text;
    }
}
