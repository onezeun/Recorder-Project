package com.record.backend.aws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Uploader {
	private final AmazonS3Client amazonS3Client;

	/*@Value("${cloud.aws.s3.bucket}")
	public String bucket;

	public String upload(MultipartFile multipartFile, String dirName) throws IOException{
		File uploadFile = convert(multipartFile).orElseThrow(() -> new IllegalArgumentException("파일 전환 실패"));

		return upload(uploadFile, dirName);
	}

	//cloud front url
	public String getFileUrl(String fileName) {
		return amazonS3Client.getUrl(bucket, fileName).toString();
	}

	//get file name
	private String getFileName(String url) {
		String[] paths = url.split("/");
		return paths[paths.length-2] + "/" + paths[paths.length-1];
	}

	// S3로 파일 업로드하기
	private String upload(File uploadFile, String dirName) {
		String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.getName();   // S3에 저장된 파일 이름
		String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
		removeNewFile(uploadFile);
		return uploadImageUrl;
	}

	// S3로 업로드
	private String putS3(File uploadFile, String fileName) {
		amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile)
			.withCannedAcl(CannedAccessControlList.PublicRead));
		return amazonS3Client.getUrl(bucket, fileName).toString();
	}

	// 로컬에 저장된 이미지 지우기
	private void removeNewFile(File targetFile) {
		if (targetFile.delete()) {
			log.info("File delete success");
			return;
		}
		log.info("File delete fail");
	}

	private Optional<File> convert(MultipartFile multipartFile) throws IOException{
		File convertFile = new File(System.getProperty("desktop") + "/" + multipartFile.getOriginalFilename());
		// 바로 위에서 지정한 경로에 File이 생성됨 (경로가 잘못되었다면 생성 불가능)
		if (convertFile.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(convertFile)) { // FileOutputStream 데이터를 파일에 바이트 스트림으로 저장하기 위함
				fos.write(multipartFile.getBytes());
			}
			return Optional.of(convertFile);
		}

		return Optional.empty();

	}*/

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	public String upload(MultipartFile multipartFile, String dirName) throws IOException {
		File uploadFile = convert(multipartFile)
			.orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));

		return upload(uploadFile, dirName);
	}

	private String upload(File uploadFile, String dirName) {
		String fileName = dirName + "/" + uploadFile.getName();
		String uploadImageUrl = putS3(uploadFile, fileName);
		removeNewFile(uploadFile);
		return uploadImageUrl;
	}

	private String putS3(File uploadFile, String fileName) {
		amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
		return amazonS3Client.getUrl(bucket, fileName).toString();
	}

	private void removeNewFile(File targetFile) {
		if (targetFile.delete()) {
			log.info("파일이 삭제되었습니다.");
		} else {
			log.info("파일이 삭제되지 못했습니다.");
		}
	}

	private Optional<File> convert(MultipartFile file) throws IOException {
		File convertFile = new File(file.getOriginalFilename());
		if(convertFile.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(convertFile)) {
				fos.write(file.getBytes());
			}
			return Optional.of(convertFile);
		}

		return Optional.empty();
	}
}
