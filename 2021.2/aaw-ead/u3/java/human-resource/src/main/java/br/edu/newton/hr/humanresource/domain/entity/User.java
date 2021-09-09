package br.edu.newton.hr.humanresource.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class User {
    
    @Id
    private String id;

    private String nome;

    private int idade;

    private String pais;

    private String estado;

    private String cidade;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime modifiedAt;   
}
