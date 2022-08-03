# SOLID principle implementation

## How to run
### Required
Java version: 18.0 or above
maven: 3.8.1 or above

### Command
run from the root project
```shell
mvn spring-boot:run
```

## What is SOLID?
S - Single-responsiblity Principle
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle

### Single Responsibility principle
>A class should have one and only one reason to change, meaning that a class should have only one jo

A class should have only one responsibility.
For example controller should only handle endpoint request etc. This will be applied by using @Controller, @Service, @Entity etc

### Open-closed principle
>Objects or entities should be open for extension but closed for modification

When a feature should be updated, the higher hierarchy module should not be changed
To apply with this, using VO and DTO so that the user should be able to update attribute of VO or DTO then no need to update all the other methods.

### Liskov Substitution Principle
>Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

Subclass should have "(Subclass) is a (Superclass)" relationship and the subclass should be substituted to the superclass.
[BankAccount](/src/main/java/org/main/model/bank/BankAccount.java) is a parent class ]
then all the other classes under [account](/src/main/java/org/main/model/bank/account) are the subclasses.
They have **A is a B** relations (e.g. saving account is a bank account) 

### Interface Segregation Principle
>A client should never be forced to implement an interface that it does not use, or clients should not be forced to depend on methods they do not use.

The dependencies rely on interfaces instead of class itself.

see implementation of [Depositable, Transferrable and Withdrawable](/src/main/java/org/main/model/bank/function) and [service class to use them](/src/main/java/org/main/service/BankManagingService.java)

### Dependency Inversion Principle
>The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details. Details should depend upon abstractions.

According to Uncle Bob, the higher class should use interface to apply with this principle. However with Spring @Autowire (injecting dependency), the high-level class can automatically decide which instance to be used.