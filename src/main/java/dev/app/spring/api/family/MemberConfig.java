package dev.app.spring.api.family;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Anish Panthi
 */
@Configuration
public class MemberConfig {

  @Bean
  public WebClient createWebClient() {
    return WebClient.builder()
        .baseUrl("http://localhost:8080")
        .build();
  }

  @Bean
  public HttpServiceProxyFactory createProxyFactory(WebClient webClient) {
    return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
  }

  @Bean
  public MemberClient createMemberClient(HttpServiceProxyFactory httpServiceProxyFactory) {
    return httpServiceProxyFactory.createClient(MemberClient.class);
  }
}
