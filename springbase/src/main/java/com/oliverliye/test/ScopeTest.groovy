package com.oliverliye.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component


@Component
class SingleScopeBean {

    @Value('2')
    long id
    @Value('oliver2')
    String userName
    @Value('note2')
    String note

}


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeScopeBean {

    @Value('2')
    long id
    @Value('oliver2')
    String userName
    @Value('note2')
    String note

}


@Configuration
@ComponentScan
class ScopeTestConfig {
}


def ctx = new AnnotationConfigApplicationContext(ScopeTestConfig)

def singleBean1 = ctx.getBean(SingleScopeBean)
def singleBean2 = ctx.getBean(SingleScopeBean)
assert singleBean1 == singleBean2 : "#### SCOPE_SINGLE ####"

prototypeBean1 = ctx.getBean(PrototypeScopeBean)
prototypeBean2 = ctx.getBean(PrototypeScopeBean)
assert prototypeBean1 != prototypeBean2 : "#### SCOPE_PROTOTYPE ####"