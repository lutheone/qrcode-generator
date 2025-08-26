package com.lutheone.qrcode.generator.controller;

import com.lutheone.qrcode.generator.dto.QrCodeGenerateRequest;
import com.lutheone.qrcode.generator.dto.QrcodeGenerateResponse;
import com.lutheone.qrcode.generator.service.QrCodeGeneratorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeService) {
        this.qrCodeGeneratorService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrcodeGenerateResponse> generateQrCode
            (@RequestBody QrCodeGenerateRequest request) {
        try {
            QrcodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
                   return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
