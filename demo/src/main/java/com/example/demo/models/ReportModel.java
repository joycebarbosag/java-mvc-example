package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
// @Table(name="reports", schema="chama")
@Getter
@Setter
@AllArgsConstructor
public class ReportModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;
    private boolean isFire;
    private boolean status;
    @Lob
    private byte[] img;
    @Lob
    private String base64Image;
    private Long userId;

    public ReportModel(){
        this.isFire = false;
        this.status = true;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    @JsonManagedReference
    private ReportAddressModel address;

}   
