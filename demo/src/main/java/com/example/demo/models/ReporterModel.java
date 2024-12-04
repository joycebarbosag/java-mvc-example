package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @Table(name="reporters", schema="chama")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReporterModel extends UserModel {

    private String cpf;
    
}
