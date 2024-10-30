package org.example.Keyword;

import lombok.*;
import org.example.Topic.TopicDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeywordDTO {
    private String category;
    private String value;
    private TopicDTO description;

    @Override
    public String toString() {
        return "Keywords: " + category + " " + value;
    }
}
