package com.oliverliye.config


import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = "com.oliverliye.pojo")
class AppScanConfig {
}
