package model;

import annotation.MinValor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
public class Empleat {

    @NotEmpty
    private UUID id;
    private String nom;
    private String mail;
    @MinValor(value = 500, message = "No em pagues prou")
    private BigDecimal salari;

    public Empleat (UUID id, String nom, String mail, BigDecimal salari) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
        this.salari = salari;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public BigDecimal getSalari() {
        return salari;
    }

    public void setSalari(BigDecimal salari) {
        this.salari = salari;
    }
}
