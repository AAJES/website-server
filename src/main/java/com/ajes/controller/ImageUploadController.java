package com.ajes.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.ajes.model.Career;
import com.ajes.model.ImageModel;
import com.ajes.service.CareerService;
import com.ajes.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;


@RestController
@RequestMapping("/ajes")
@CrossOrigin(origins = "https://project-client-kappa.vercel.app/")
public class ImageUploadController {
	@Autowired
	private ImageService imageService;

//	@Autowired
//	private VisitorService visitorService;
//
//	@Autowired
//	private EmailService emailService;
	
	@Autowired
	private CareerService careerService;

	@GetMapping("/hi")
	public String getName(String string) {
		return "HI";
	}

	
	@PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@CrossOrigin(origins = "http://localhost:4200")
	public ImageModel uploadImage(@RequestBody MultipartFile file)
			throws IOException {
		System.out.println(".......Image Controller");
		System.out.println("File Name:" + file.getOriginalFilename());
		System.out.println("File Name:" + file.getContentType());
		System.out.println("File Name:" + file.getName());
//		System.out.println("File Name:" + file.getSize();

//		imageService.uploadImage(file);
		System.out.println("Image Controller.......");

		ImageModel imageModel = imageService.uploadImage(file);

//		Visitor visitor = visitorService.findVisitor(visitor_id);
//		visitor.setVisitor_photo(imageModel);
//		visitorService.addVisitor(visitor);
	
		return imageModel;

	}

	@GetMapping("/getImageName/{name}")
	public Optional<ImageModel> downloadByName(@PathVariable("name") String name) {
		System.out.println(".........Download Controller");
		return imageService.downloadByName(name);

	}

	private static final String FILE_DIRECTORY = "D:\\";

	//private static final String FILE_DIRECTORY = "D:\\temp\\";


	@GetMapping("/downloadImage/{fileName:.+}")
	public ResponseEntity<Object> downloadImage(@PathVariable("fileName") String fileName) throws IOException {
		System.out.println(".........Download Controller");
//        Path filePath = Paths.get(FILE_DIRECTORY, fileName);
//        Optional<File> file = getFile(filePath);
		File file = new File(FILE_DIRECTORY,fileName);
		System.out.println(fileName);
		System.out.println(".........Download Controller.........");
		return imageService.downloadByType(file);
	}
	
	@GetMapping("/downloadImage2/{careerId}")
	public ResponseEntity<Object> downloadImage2(@PathVariable("careerId") Integer careerId) throws IOException {
		System.out.println(".........Download Controller");
//        Path filePath = Paths.get(FILE_DIRECTORY, fileName);
//        Optional<File> file = getFile(filePath);
		List<Career> list = careerService.getAllCareer();
		
		for(Career c : list) {
			if(c.getCareerId()==careerId) {
				File file = new File(FILE_DIRECTORY,c.getAttachFile());
				System.out.println(c.getAttachFile());
				System.out.println(".........Download Controller.........");
				return imageService.downloadByType(file);
			}
		}
		return null;
		
	}

	@GetMapping("/downloadImageQr/{fileName:.+}")
	public ResponseEntity<Object> downloadImage1(@PathVariable("fileName") String fileName) throws IOException {
		System.out.println(".........Download Controller");
//        Path filePath = Paths.get(FILE_DIRECTORY1, fileName);
//        Optional<File> file = getFile(filePath);
		File file = new File(FILE_DIRECTORY,fileName);
		System.out.println(".........Download Controller.........");
		return imageService.downloadByType(file);
	}

	@GetMapping("/downloadImage1/{id}")
	public String getImageById(@PathVariable("id") Long id) {
		return imageService.getImageById(id);

	}

//	@PostMapping("/upload-pdf/{visitor_id}")
//    public ResponseEntity<String> uploadPdfAndSendEmail(@RequestParam("pdfFile") MultipartFile pdfFile,@PathVariable() Long visitor_id) {
//        if (!pdfFile.isEmpty()) {
//            byte[] pdfContent;
//            try {
//                pdfContent = pdfFile.getBytes();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return new ResponseEntity<>("Error uploading PDF", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//
//			EmailDetails emailDetails = new EmailDetails();
//
//			Visitor visitor = visitorService.findVisitor(visitor_id);
//
//			emailDetails.setRecipient(visitor.getVisitor_email());
//			emailDetails.setSubject("This is your appointment details");
//			emailDetails.setAttachment(pdfFile);
//
//            emailService.sendEmailWithAttachment(pdfContent);
//
//            return new ResponseEntity<>("PDF uploaded and email sent", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("PDF file is empty", HttpStatus.BAD_REQUEST);
//        }
//    }

}
