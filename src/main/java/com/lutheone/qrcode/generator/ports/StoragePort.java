package com.lutheone.qrcode.generator.ports;

public interface StoragePort {

    String uploadFile(byte[] filedata, String fileName, String contentType);
}
