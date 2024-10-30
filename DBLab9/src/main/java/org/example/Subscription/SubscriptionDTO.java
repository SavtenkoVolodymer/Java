package org.example.Subscription;

import lombok.*;
import org.example.Client.ClientDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {
    private String topics;
    private String notification_format;
    private String keywords;
    private ClientDTO id;

    @Override
    public String toString() {
        return "Subscription: " + topics + " " + keywords;
    }
}
