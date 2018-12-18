package com.oliverliye.config

import com.oliverliye.pojo.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(name="User")
    User initUser() {
        def user = new User()
        user.id = 1L
        user.userName = 'oliver'
        user.note = 'note'
        user
    }
}
