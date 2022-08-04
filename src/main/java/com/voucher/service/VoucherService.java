package com.voucher.service;

import com.voucher.assembler.VoucherAssembler;
import com.voucher.dto.CreateVoucherDTO;
import com.voucher.dto.UpdateVoucherDTO;
import com.voucher.dto.VoucherDTO;
import com.voucher.model.Voucher;
import com.voucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {

    VoucherAssembler assembler;

    VoucherRepository repository;

    @Autowired
    public VoucherService(VoucherRepository repository, VoucherAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public List<VoucherDTO> listar(String email, String ofertaEspecial) {
        List<Voucher> listVoucher;
        if (ofertaEspecial != null) {
            listVoucher = repository.findByEmailAndOfertaEspecialAndDataValidadeAfter(email, ofertaEspecial, new Date());
        } else {
            listVoucher = repository.findByEmailAndDataValidadeAfter(email, new Date());
        }

        List<VoucherDTO> dtos = new ArrayList<>();
        if (listVoucher != null) {
            listVoucher.forEach(v -> {
                dtos.add(assembler.transformar(v));
            });
        }

        return dtos;
    }

    public VoucherDTO criar(@NotNull CreateVoucherDTO dto) {
        Voucher voucher = assembler.criarVoucher(dto);
        voucher = repository.save(voucher);

        VoucherDTO voucherDto = assembler.transformar(voucher);

        return voucherDto;
    }

    public VoucherDTO atualizar(@NotNull UpdateVoucherDTO dto) throws Exception {

        Optional<Voucher> voucherOptional = repository.findByIdVoucherAndEmailAndOfertaEspecial(dto.getIdVoucher(), dto.getEmail(), dto.getOfertaEspecial());
         if (!voucherOptional.isPresent()){
             throw new Exception("voucher not found");
         }

        Voucher voucherUtilizado = voucherOptional.get();
         if (voucherUtilizado.getDataDeUso() != null) {
             throw new Exception("Voucher já utilizado");
         }
        voucherUtilizado.setDataDeUso(new Date());


        VoucherDTO voucherDto = assembler.transformar(repository.save(voucherUtilizado));

        return voucherDto;
    }
}
