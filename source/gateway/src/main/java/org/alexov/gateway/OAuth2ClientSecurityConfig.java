package org.alexov.gateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OAuth2ClientSecurityConfig {

	@Bean
	@ConditionalOnProperty(value = "auth.enable", havingValue = "true")
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(ex -> ex
						.pathMatchers("/api/user", "/api/user/**").authenticated()
						.anyExchange().permitAll())
				.csrf(ServerHttpSecurity.CsrfSpec::disable)
				.cors(ServerHttpSecurity.CorsSpec::disable)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.oauth2Login(Customizer.withDefaults())
			.oauth2Client(Customizer.withDefaults());

		return http.build();
	}
	@Bean
	@ConditionalOnProperty(value = "auth.enable", havingValue = "false")
	public SecurityWebFilterChain securityWebFilterChainDisabled(ServerHttpSecurity http) {
		http.authorizeExchange(ex -> ex.anyExchange().permitAll())
				.csrf(ServerHttpSecurity.CsrfSpec::disable)
				.cors(ServerHttpSecurity.CorsSpec::disable)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.oauth2Login(Customizer.withDefaults())
				.oauth2Client(Customizer.withDefaults());

		return http.build();
		}
}