package me.jimmy.hellospring.storage.db.main.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class MainDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "hello-spring.datasource.main")
    fun mainHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun mainDataSource(@Qualifier("mainHikariConfig") config: HikariConfig): HikariDataSource {
        return HikariDataSource(config)
    }
}