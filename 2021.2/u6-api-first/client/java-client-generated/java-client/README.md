# swagger-java-client


- API version: 1.0.0
  - Build date: 2021-11-09T00:39:07.865Z

No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.PetApi;

import java.io.File;
import java.util.*;

public class PetApiExample {

    public static void main(String[] args) {
        
        PetApi apiInstance = new PetApi();
        Pet body = new Pet(); // Pet | Pet a ser criado
        try {
            Pet result = apiInstance.criarPet(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PetApi#criarPet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PetApi* | [**criarPet**](docs/PetApi.md#criarPet) | **POST** /pets | Cria un novo Pet.
*PetApi* | [**deletePetById**](docs/PetApi.md#deletePetById) | **DELETE** /pets/{id} | Deleta um Pet da loja a partir do ID.
*PetApi* | [**getAllPets**](docs/PetApi.md#getAllPets) | **GET** /pets | Lista todos os Pets da loja.
*PetApi* | [**getPetById**](docs/PetApi.md#getPetById) | **GET** /pets/{id} | Retorna um Pet da loja a partir do ID.
*PetApi* | [**updatePetById**](docs/PetApi.md#updatePetById) | **PUT** /pets/{id} | Atualiza um Pet da loja a partir do ID.


## Documentation for Models

 - [Pet](docs/Pet.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

waldir.junior@newtonpaiva.br
