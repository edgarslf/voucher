package com.voucher.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class VoucherDTO implements Serializable {


    @NotNull
    private String idVoucher;

    private String nome;

    @Email
    private String email;

    @NotNull
    private String ofertaEspecial;

    @NotNull
    private Integer descontoPercentualFixo;

    @NotNull
    private Date dataValidade;

    private Date dataDeUso;

}
