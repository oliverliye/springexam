package com.oliverliye.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

interface Person {
    void service()
    void setAnimal(Animal animal)
    String getName()
}

interface Animal {
    void use()
    String getName()

}

@Component
class BussinessPerson implements Person {

    @Autowired
    Animal dog = null

    @Override
    void service() {
        this.dog.use()
    }

    @Override
    void setAnimal(Animal animal) {
        this.dog = animal
    }

    @Override
    String getName() {
        return this.dog.getName()
    }
}

@Component
class NormalPerson implements Person {

    @Autowired
    @Qualifier("dog")
    Animal animal = null

    @Override
    void service() {
        this.animal.use()
    }

    @Override
    void setAnimal(Animal animal) {
        this.animal = animal
    }

    @Override
    String getName() {
        return this.animal.getName()
    }
}


@Component
class ParamPerson implements Person {

    Animal animal = null

    ParamPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal
    }


    @Override
    void service() {
        this.animal.use()
    }

    @Override
    void setAnimal(Animal animal) {
        this.animal = animal
    }

    @Override
    String getName() {
        return this.animal.getName()
    }
}

@ComponentScan
class AutowiredConfig {
}

@Component
class Dog implements Animal {

    @Override
    void use() {
        println("狗 ${Dog.class.getName()} 就看门用的。")
    }

    @Override
    String getName() {
        return 'dog'
    }
}

@Component
@Primary
class Cat implements Animal {
    @Override
    void use() {
        println("猫 ${Cat.class.getName()} 就抓老鼠的。")
    }

    @Override
    String getName() {
        return 'cat'
    }
}


def ctx = new AnnotationConfigApplicationContext(AutowiredConfig)
BussinessPerson bean = ctx.getBean(BussinessPerson)
bean.service()

assert bean.getName() == 'cat'

NormalPerson bean2 = ctx.getBean(NormalPerson)
bean2.service()

assert bean2.getName() == 'dog'

ParamPerson bean3 = ctx.getBean(ParamPerson)
bean3.service()

assert bean3.getName() == 'dog'