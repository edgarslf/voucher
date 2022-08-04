package com.voucher.assembler;

import com.voucher.dto.CreateVoucherDTO;
import com.voucher.dto.UpdateVoucherDTO;
import com.voucher.dto.VoucherDTO;
import com.voucher.model.Voucher;
import org.springframework.stereotype.Component;

@Component
public class VoucherAssembler {

    public VoucherDTO transformar(Voucher voucher) {
        VoucherDTO dto = new VoucherDTO();
        dto.setIdVoucher(voucher.getIdVoucher().toString());
        dto.setDataDeUso(voucher.getDataDeUso());
        dto.setDataValidade(voucher.getDataValidade());
        dto.setOfertaEspecial(voucher.getOfertaEspecial());
        dto.setDescontoPercentualFixo(voucher.getDescontoPercentualFixo());
        dto.setEmail(voucher.getEmail());
        dto.setNome(voucher.getNome());

        return dto;
    }

    public Voucher criarVoucher(CreateVoucherDTO dto) {
        Voucher voucher = new Voucher();
        voucher.setDataValidade(dto.getDataValidade());
        voucher.setOfertaEspecial(dto.getOfertaEspecial());
        voucher.setDescontoPercentualFixo(dto.getDescontoPercentualFixo());
        voucher.setEmail(dto.getEmail());
        voucher.setNome(dto.getNome());
        return voucher;
    }

    public Voucher utilizarVoucher(UpdateVoucherDTO dto) {
        return null;
    }
}
