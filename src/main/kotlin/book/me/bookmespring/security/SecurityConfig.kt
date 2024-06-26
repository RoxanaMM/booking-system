package book.me.bookmespring.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize(anyRequest, authenticated)
            }
            formLogin { }
            httpBasic { }
        }

        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user)
    }

}