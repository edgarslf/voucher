package com.voucher.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class CreateVoucherDTO implements Serializable {

    @NotNull
    private String nome;

    @Email
    private String email;

    @NotNull
    private String ofertaEspecial;

    @NotNull
    private Integer descontoPercentualFixo;

    @NotNull
    private Date dataValidade;
}
