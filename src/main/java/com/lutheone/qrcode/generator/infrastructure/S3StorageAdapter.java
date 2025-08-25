package com.lutheone.qrcode.generator.infrastructure;

import com.lutheone.qrcode.generator.ports.StoragePort;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;

public class S3StorageAdapter implements StoragePort {

    private final S3Client s3Client;
    private final String bucketName;
    private final String region;

    public S3StorageAdapter(@Value("${aws.region}") String region,
                            @Value("${aws.s3.bucket-name}") String bucketName,
                            S3Client s3Client) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    @Override
    public String uploadFile(byte[] filedata, String fileName, String contentType) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(filedata.length);
        metadata.setContentType(contentType);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(filedata);
        putObjectRequest request = new PutObjectRequest(bucketName, fileName, byteArrayInputStream, metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        s3Client.putObject(request);

        return s3Client.getUrl(bucketName, fileName).toString();
}
