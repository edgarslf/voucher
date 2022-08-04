package com.voucher.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateVoucherDTO implements Serializable {

    @NotNull
    private String idVoucher;

    @Email
    private String email;

    @NotNull
    private String ofertaEspecial;
}
