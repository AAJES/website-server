package com.ajes.service;



import com.ajes.model.ImageModel;
import com.ajes.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.io.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public ImageModel uploadImage(MultipartFile file) throws IOException {
		System.out.println(".........Image Service");
		String filePath = "D:\\";
		String fileName = "logo_" + file.getOriginalFilename()+LocalDate.now();
		File imageFile = new File(filePath, fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(imageFile);

		ImageModel imageMode2 = new ImageModel(null, imageFile.getName(), imageFile.getAbsolutePath(), fileName);

		////////////////////// save and compress

		byte[] compressedBytes = compressedBytes(file.getBytes());
		fileOutputStream.write(compressedBytes);

//		/////// save local //////
		//fileOutputStream.write(file.getBytes());

		fileOutputStream.close();
		System.out.println("Image uploaded successfully");
		System.out.println("Image Service.......");
		return  imageRepository.save(imageMode2);

	}

	public byte[] compressedBytes(byte[] data) {

		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1000000000];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	public ResponseEntity<Object> downloadByType(File file) throws IOException {
		System.out.println(".............Image download Service");

		FileInputStream fin = new FileInputStream(file);
		byte[] fileBytes = fin.readAllBytes();
////////decompress/////////////
		byte[] decompressedBytes = decompressBytes(fileBytes);

		/////////////////////////////
		fin.close();
		System.out.println("Image download Service.......");
		return ResponseEntity.status(HttpStatus.OK).body(decompressedBytes);

	}

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	public String getImageById(Long id) {
		System.out.println("........");
		Optional<ImageModel> opt = imageRepository.findById(id);
		opt.get().getName();
		System.out.println("sImage Name" + opt.get().getName());
		return opt.get().getName();
	}

	public ImageModel getImageById1(Long id) {
		System.out.println("........");
		Optional<ImageModel> opt = imageRepository.findById(id);
		opt.get().getName();
		System.out.println("sImage Name" + opt.get().getName());
		return opt.get();
	}

	public Optional<ImageModel> downloadByName(String name) {
		// TODO Auto-generated method stub
		return imageRepository.findByName(name);

	}

}
