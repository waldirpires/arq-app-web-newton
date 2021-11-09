/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: waldir.junior@newtonpaiva.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * Pet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-09T00:39:07.865Z")
public class Pet {
  @SerializedName("id")
  private String id = null;

  @SerializedName("nome")
  private String nome = null;

  /**
   * Espécie do Pet
   */
  @JsonAdapter(EspecieEnum.Adapter.class)
  public enum EspecieEnum {
    CANINO("canino"),
    
    FELINO("felino"),
    
    AVE("ave"),
    
    REPTIL("reptil"),
    
    MAMIFERO("mamifero");

    private String value;

    EspecieEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EspecieEnum fromValue(String text) {
      for (EspecieEnum b : EspecieEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<EspecieEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EspecieEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EspecieEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EspecieEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("especie")
  private EspecieEnum especie = null;

  @SerializedName("raca")
  private String raca = null;

  @SerializedName("foto")
  private String foto = null;

  @SerializedName("idade")
  private Integer idade = null;

  /**
   * Status do Pet
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    CRIADO("criado"),
    
    VENDIDO("vendido"),
    
    EXCLUIDO("excluido");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("dataDeCriacao")
  private OffsetDateTime dataDeCriacao = null;

  @SerializedName("dataDeModificacao")
  private OffsetDateTime dataDeModificacao = null;

  public Pet id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "b0e453b3-d54b-4fe8-818a-035b5fb3851d", value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Pet nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * Get nome
   * @return nome
  **/
  @ApiModelProperty(example = "cão", value = "")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Pet especie(EspecieEnum especie) {
    this.especie = especie;
    return this;
  }

   /**
   * Espécie do Pet
   * @return especie
  **/
  @ApiModelProperty(example = "canino", value = "Espécie do Pet")
  public EspecieEnum getEspecie() {
    return especie;
  }

  public void setEspecie(EspecieEnum especie) {
    this.especie = especie;
  }

  public Pet raca(String raca) {
    this.raca = raca;
    return this;
  }

   /**
   * Get raca
   * @return raca
  **/
  @ApiModelProperty(example = "beagle", value = "")
  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public Pet foto(String foto) {
    this.foto = foto;
    return this;
  }

   /**
   * Get foto
   * @return foto
  **/
  @ApiModelProperty(example = "http://newtonpaiva.br/pets/001.jpg", value = "")
  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Pet idade(Integer idade) {
    this.idade = idade;
    return this;
  }

   /**
   * Get idade
   * @return idade
  **/
  @ApiModelProperty(example = "8", value = "")
  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Pet status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status do Pet
   * @return status
  **/
  @ApiModelProperty(example = "criado", value = "Status do Pet")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Pet dataDeCriacao(OffsetDateTime dataDeCriacao) {
    this.dataDeCriacao = dataDeCriacao;
    return this;
  }

   /**
   * Get dataDeCriacao
   * @return dataDeCriacao
  **/
  @ApiModelProperty(example = "2021-11-08 20:05:00", value = "")
  public OffsetDateTime getDataDeCriacao() {
    return dataDeCriacao;
  }

  public void setDataDeCriacao(OffsetDateTime dataDeCriacao) {
    this.dataDeCriacao = dataDeCriacao;
  }

  public Pet dataDeModificacao(OffsetDateTime dataDeModificacao) {
    this.dataDeModificacao = dataDeModificacao;
    return this;
  }

   /**
   * Get dataDeModificacao
   * @return dataDeModificacao
  **/
  @ApiModelProperty(example = "2021-11-08 20:05:00", value = "")
  public OffsetDateTime getDataDeModificacao() {
    return dataDeModificacao;
  }

  public void setDataDeModificacao(OffsetDateTime dataDeModificacao) {
    this.dataDeModificacao = dataDeModificacao;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return Objects.equals(this.id, pet.id) &&
        Objects.equals(this.nome, pet.nome) &&
        Objects.equals(this.especie, pet.especie) &&
        Objects.equals(this.raca, pet.raca) &&
        Objects.equals(this.foto, pet.foto) &&
        Objects.equals(this.idade, pet.idade) &&
        Objects.equals(this.status, pet.status) &&
        Objects.equals(this.dataDeCriacao, pet.dataDeCriacao) &&
        Objects.equals(this.dataDeModificacao, pet.dataDeModificacao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, especie, raca, foto, idade, status, dataDeCriacao, dataDeModificacao);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    especie: ").append(toIndentedString(especie)).append("\n");
    sb.append("    raca: ").append(toIndentedString(raca)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    idade: ").append(toIndentedString(idade)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dataDeCriacao: ").append(toIndentedString(dataDeCriacao)).append("\n");
    sb.append("    dataDeModificacao: ").append(toIndentedString(dataDeModificacao)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

