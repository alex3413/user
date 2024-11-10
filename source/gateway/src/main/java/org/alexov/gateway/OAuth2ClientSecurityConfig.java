package org.alexov.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OAuth2ClientSecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(ex -> ex.pathMatchers("/api/registration", "/auth/**").permitAll()
						.anyExchange().authenticated())
				.csrf(ServerHttpSecurity.CsrfSpec::disable)
				.cors(ServerHttpSecurity.CorsSpec::disable)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.oauth2Login(Customizer.withDefaults())
			.oauth2Client(Customizer.withDefaults());

		return http.build();
	}
}