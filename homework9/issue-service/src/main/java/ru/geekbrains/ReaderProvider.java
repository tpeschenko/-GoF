package ru.geekbrains;

import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ReaderProvider {

    private final WebClient webClient;

    public ReaderProvider(EurekaClient eurekaClient,
                        ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public ReaderDto getRandomReaderDto() {
        return webClient.get()
                .uri("http://reader-service/reader/random")
                .retrieve()
                .bodyToMono(ReaderDto.class)
                .block();
    }

}
