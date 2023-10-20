//package com.example.plandsSite.Controller;
//
//import com.example.plandsSite.Service.CodeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/code")
//public class CodeController {
//    @Autowired
////    private CodeService codeService;
//
////    @Value("${code.password}")
////    private String codePassword;
//
//    @PostMapping("/generate")
//    public ResponseEntity<String> generateCode(@RequestParam String password) {
//        if (!codePassword.equals(password)) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid password");
//        }
//        UUID code = codeService.generateAndStoreCode();
//        return ResponseEntity.ok(code.toString());
//    }
//}
