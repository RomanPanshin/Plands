//package com.example.plandsSite.Controller;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/img")
//public class ImageController {
//
//    @GetMapping("/cityscape.jpg")
//    public ResponseEntity<Resource> serveCityscapeImage() throws IOException {
//        Resource imageResource = new ClassPathResource("static/img/cityscape.jpg");
//        if (!imageResource.exists()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(imageResource);
//    }
//}
