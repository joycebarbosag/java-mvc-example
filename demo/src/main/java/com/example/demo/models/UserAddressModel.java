package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
// @Table(name="address", schema="chama")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAddressModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String zipCode;
    private String street;
    private int houseNumber;
    private String neighborhood;
    private String city;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private UserModel userModel;

}
