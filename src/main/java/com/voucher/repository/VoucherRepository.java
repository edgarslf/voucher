package com.voucher.repository;

import com.voucher.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VoucherRepository  extends MongoRepository<Voucher, String> {


    public List<Voucher> findByEmailAndDataValidadeAfter(String email, Date dataValidade);

    List<Voucher> findByEmailAndOfertaEspecialAndDataValidadeAfter(String email, String ofertaEspecial, Date dataValidade);

    Optional<Voucher> findByIdVoucherAndEmailAndOfertaEspecial(String idVoucher, String email, String ofertaEspecial);
}
