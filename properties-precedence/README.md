# Spring Boot properties precedence test

Test the precedence of properties imported by [PropertySourcesPlaceholderConfigurer#setLocations](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/support/PropertySourcesPlaceholderConfigurer.html)

* Does they have higher precedence than application properties?
* Does they have higher precedence than profile-specific application properties?
* Does they have higher precedence than system properties?

## Run

Just start `Application` and check its console output.

Change some configurations and recheck the output:

* Comment/uncomment the line `System.setProperty("test.origin", "System Properties")` in `Application`
* Change Spring Boot version in `pom.xml`(1.5.14 VS 2.0.4)
* Enable or disable the development profile (comment/uncomment `spring.profiles.active=development` in `application.properties`)

## Sample output

Spring Boot 2.0.4 + No system property + Disable development profile:

```
            @ConfigurationProperties: test.properties
     XML placeholder TestProperties: test.properties
    XML placeholder Test2Properties: application.properties
                             @Value: application.properties
```

Spring Boot 2.0.4 + No system property + Enable development profile:

```
            @ConfigurationProperties: test.properties
     XML placeholder TestProperties: test.properties
    XML placeholder Test2Properties: application-development.properties
                             @Value: application-development.properties
```

Spring Boot 2.0.4 + With system property + Enable development profile:

```
            @ConfigurationProperties: test.properties
     XML placeholder TestProperties: test.properties
    XML placeholder Test2Properties: System Properties
                             @Value: System Properties
```

Spring Boot 1.5.14 + No system property + Disable development profile:

```
            @ConfigurationProperties: application.properties
     XML placeholder TestProperties: application.properties
    XML placeholder Test2Properties: application.properties
                             @Value: application.properties
```

Spring Boot 1.5.14 + No system property + Enable development profile:

```
            @ConfigurationProperties: application-development.properties
     XML placeholder TestProperties: application-development.properties
    XML placeholder Test2Properties: application-development.properties
                             @Value: application-development.properties
```

Spring Boot 1.5.14 + With system property + Enable development profile:

```
            @ConfigurationProperties: System Properties
     XML placeholder TestProperties: System Properties
    XML placeholder Test2Properties: System Properties
                             @Value: System Properties
```

## Conclusion

In Spring Boot 1.5.14, properties imported by `PropertySourcesPlaceholderConfigurer#setLocations` always have lowest precedence (works like `@PropertySource`).

In Spring Boot 2.0.4, properties imported by `PropertySourcesPlaceholderConfigurer#setLocations` have inconsistent behavior:

* For `@ConfigurationProperties`, they always have highest precedence, even higher than system properties
* For `@Value` bindings, they always have lowest precedence. Works in the same way as Spring Boot 1.5.14
* For XML property placeholder:
  * If there is just one bean of the same type, they work in the same way as `@Value`
  * If there is also a `@ConfigurationProperties` bean, they work in the same way as `@ConfigurationProperties`

## Problems

The inconsistent behavior in Spring Boot 2.0.4 might be a bug introduced by the [refactor of configuration property binding mechanism](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes#configuration-property-binding).
