package com.oliverliye


class Person {
    String name
    int age

    Person(name, age) {
        this.name = name
        this.age =age
    }
}

def person1 = new Person('oliver1', 35)
def person2 = ['oliver2', 30] as Person
Person person3 = ['oliver3', 30]

println person1.name
println person2.name
println person3.name

