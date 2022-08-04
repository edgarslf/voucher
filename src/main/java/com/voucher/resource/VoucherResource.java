package com.voucher.resource;

import com.voucher.dto.CreateVoucherDTO;
import com.voucher.dto.UpdateVoucherDTO;
import com.voucher.dto.VoucherDTO;
import com.voucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/voucher")
public class VoucherResource {

    @Autowired
    private VoucherService service;

    @GetMapping()
    public ResponseEntity<?> find(@RequestParam String email,
                                  @RequestParam(required = false) String ofertaEspecial) {
        try {
            List<VoucherDTO> vouchers = service.listar(email, ofertaEspecial);
            return new ResponseEntity<>(vouchers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<VoucherDTO> create(@RequestBody CreateVoucherDTO dto) {
        try {
            VoucherDTO voucher = service.criar(dto);
            return new ResponseEntity<>(voucher, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<VoucherDTO> update(@RequestBody UpdateVoucherDTO dto) {
        try {
            VoucherDTO voucher = service.atualizar(dto);
            return new ResponseEntity<>(voucher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
