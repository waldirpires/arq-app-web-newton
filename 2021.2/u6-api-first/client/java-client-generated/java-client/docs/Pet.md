
# Pet

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**nome** | **String** |  |  [optional]
**especie** | [**EspecieEnum**](#EspecieEnum) | Espécie do Pet |  [optional]
**raca** | **String** |  |  [optional]
**foto** | **String** |  |  [optional]
**idade** | **Integer** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status do Pet |  [optional]
**dataDeCriacao** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**dataDeModificacao** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]


<a name="EspecieEnum"></a>
## Enum: EspecieEnum
Name | Value
---- | -----
CANINO | &quot;canino&quot;
FELINO | &quot;felino&quot;
AVE | &quot;ave&quot;
REPTIL | &quot;reptil&quot;
MAMIFERO | &quot;mamifero&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
CRIADO | &quot;criado&quot;
VENDIDO | &quot;vendido&quot;
EXCLUIDO | &quot;excluido&quot;



