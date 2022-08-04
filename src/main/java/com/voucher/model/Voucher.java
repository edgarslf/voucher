package com.voucher.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@Getter @Setter
public class Voucher{


    @Id
    private ObjectId idVoucher;

    @NotNull
    private String nome;

    @Email
    private String email;

    private String ofertaEspecial;

    private Integer descontoPercentualFixo;

    private Date dataValidade;

    private Date dataDeUso;
    
}