# PetApi

All URIs are relative to *http://localhost:8080/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**criarPet**](PetApi.md#criarPet) | **POST** /pets | Cria un novo Pet.
[**deletePetById**](PetApi.md#deletePetById) | **DELETE** /pets/{id} | Deleta um Pet da loja a partir do ID.
[**getAllPets**](PetApi.md#getAllPets) | **GET** /pets | Lista todos os Pets da loja.
[**getPetById**](PetApi.md#getPetById) | **GET** /pets/{id} | Retorna um Pet da loja a partir do ID.
[**updatePetById**](PetApi.md#updatePetById) | **PUT** /pets/{id} | Atualiza um Pet da loja a partir do ID.


<a name="criarPet"></a>
# **criarPet**
> Pet criarPet(body)

Cria un novo Pet.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PetApi;


PetApi apiInstance = new PetApi();
Pet body = new Pet(); // Pet | Pet a ser criado
try {
    Pet result = apiInstance.criarPet(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#criarPet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Pet**](Pet.md)| Pet a ser criado |

### Return type

[**Pet**](Pet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePetById"></a>
# **deletePetById**
> deletePetById(id)

Deleta um Pet da loja a partir do ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PetApi;


PetApi apiInstance = new PetApi();
String id = "id_example"; // String | ID do Pet a ser retornado
try {
    apiInstance.deletePetById(id);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#deletePetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID do Pet a ser retornado |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllPets"></a>
# **getAllPets**
> List&lt;Pet&gt; getAllPets()

Lista todos os Pets da loja.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PetApi;


PetApi apiInstance = new PetApi();
try {
    List<Pet> result = apiInstance.getAllPets();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#getAllPets");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPetById"></a>
# **getPetById**
> Pet getPetById(id)

Retorna um Pet da loja a partir do ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PetApi;


PetApi apiInstance = new PetApi();
String id = "id_example"; // String | ID do Pet a ser retornado
try {
    Pet result = apiInstance.getPetById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#getPetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID do Pet a ser retornado |

### Return type

[**Pet**](Pet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePetById"></a>
# **updatePetById**
> Pet updatePetById(id, body)

Atualiza um Pet da loja a partir do ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PetApi;


PetApi apiInstance = new PetApi();
String id = "id_example"; // String | ID do Pet a ser retornado
Pet body = new Pet(); // Pet | Pet a ser criado
try {
    Pet result = apiInstance.updatePetById(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#updatePetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID do Pet a ser retornado |
 **body** | [**Pet**](Pet.md)| Pet a ser criado |

### Return type

[**Pet**](Pet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

