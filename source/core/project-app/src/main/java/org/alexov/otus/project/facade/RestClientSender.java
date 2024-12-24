package org.alexov.otus.project.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestClientSender {
    private final RestTemplate restTemplate;
    @Value("${url.user.profile}")
    private String url;

    public Long getUserProfile() {
        return restTemplate.getForObject(url, Long.class);
    }
}
