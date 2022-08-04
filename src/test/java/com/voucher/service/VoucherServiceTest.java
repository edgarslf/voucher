package com.voucher.service;

import com.voucher.assembler.VoucherAssembler;
import com.voucher.model.Voucher;
import com.voucher.repository.VoucherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VoucherServiceTest {

    @Mock
    VoucherRepository repository;

    @Mock
    VoucherAssembler assembler;

    VoucherService service;

    @BeforeAll
    public void setup() {
        service = new VoucherService(repository, assembler);
    }

    @Test
    public void deveRetornarListaDeVoucher(){
        Mockito.when(repository.findByEmailAndOfertaEspecialAndDataValidadeAfter(Mockito.anyString(), Mockito.anyString(), Mockito.any())).thenReturn(listVoucher());

        Assertions.assertNotNull(service.listar("test@test.com", "oferta teste"));
    }

    private List<Voucher> listVoucher() {
        Voucher voucher = new Voucher();
        voucher.setNome("Tester");
        voucher.setEmail("test@test.com");
        voucher.setOfertaEspecial("oferta teste");
        voucher.setDescontoPercentualFixo(15);
        voucher.setDataValidade(new Date());

        return Arrays.asList(voucher);
    }


}
