package com.lutheone.qrcode.generator.controller;

import com.lutheone.qrcode.generator.dto.QrCodeGenerateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<> generateQrCode(@RequestBody QrCodeGenerateRequest request) {


        // QR code generation logic will go here
    }
}
