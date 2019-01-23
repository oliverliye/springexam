package com.oliverliye.test

import com.oliverliye.pojo.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.FilterType
import org.springframework.stereotype.Component

@ComponentScan
class DefaultConfig {
}

@ComponentScan(basePackages = "com.oliverliye.pojo")
class ScanConfig {
}


@Component
class NormalBean {
    @Value('bean')
    String name
}


@Component
class BeanExclude {
    @Value('BeanExclude')
    String name
}

def scanCtx = new AnnotationConfigApplicationContext(ScanConfig)
def user  = scanCtx.getBean(User)
println(user.userName)

def defCtx = new AnnotationConfigApplicationContext(DefaultConfig)
def bean  = defCtx.getBean(NormalBean)
println(bean.name)

//@ComponentScan(excludeFilters = @Filter(type = FilterType.CUSTOM,classes = BeanExclude.class))
//class ScanExcludeConfig {
//}
//
//def excCtx = new AnnotationConfigApplicationContext(ScanExcludeConfig)
//def bean1  = excCtx.getBean(NormalBean)
//println(bean1.name)
//try {
//    def beanExclude  = defCtx.getBean(BeanExclude)
//    println(beanExclude.name)
//} catch(e) {
//    println("BeanExclude is exclude")
//}



