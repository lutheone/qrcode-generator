package com.lutheone.qrcode.generator.controller;

import com.lutheone.qrcode.generator.dto.QrCodeGenerateRequest;
import com.lutheone.qrcode.generator.dto.QrcodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrcodeGenerateResponse> generateQrCode
            (@RequestBody QrCodeGenerateRequest request) {
    return null;
    // QR code generation logic will go here
    }
}
