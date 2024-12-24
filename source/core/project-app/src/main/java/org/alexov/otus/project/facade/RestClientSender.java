package org.alexov.otus.project.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestClientSender {
    private final RestTemplate restTemplate;

    public Long getUserProfile() {
        return restTemplate.getForObject("/getUserProfile", Long.class);
    }
}
