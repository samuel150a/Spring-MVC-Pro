package com.xworkz.rapido.controller;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.service.RapidoService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class RapidoController {

    @Autowired
    private RapidoService rapidoService;

    public RapidoController() {
        System.out.println("Running in the RapidoController constructor");
    }

    @GetMapping("login")
    public String login() {
        System.out.println("Running in the login Method in GetMapping");
        return "Login";
    }

    @GetMapping("regi")
    public String register() {
        System.out.println("Running in the Register Method in GetMapping");
        return "Register";
    }

    @PostMapping("register")
    public String handleRegister(RapidoDto rapidoDto, Model model) {
        System.out.println("Running in the handleRegister method");
        Boolean saved = rapidoService.save(rapidoDto);
        if (saved) {
            System.out.println("Saved Successfully");
            model.addAttribute("message", "*************** Saved Successfully ***************");
            return "VerifyOtp";
        } else {
            System.out.println("Failed To Save");
            return "Register";
        }
    }

    @PostMapping("log")
    public String handleLogin(RapidoDto rapidoDto, Model model) {
        System.out.println("Running in the handleLogin method");

        RapidoDto entity = rapidoService.findByEmail(rapidoDto.getEmail());

        if (entity != null && new BCryptPasswordEncoder().matches(rapidoDto.getPassword(), entity.getPassword())) {
            try {
                if (rapidoDto.getProfilePicture() != null && !rapidoDto.getProfilePicture().isEmpty()) {
                    byte[] bytes = rapidoDto.getProfilePicture().getBytes();
                    Path path = Paths.get("D:\\SaveMe\\" + rapidoDto.getName() + System.currentTimeMillis());
                    Files.write(path, bytes);

                    entity.setProfilePic(path.getFileName().toString());
                }

                model.addAttribute("user", entity);

                return "LoginSuccessfull";

            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed");
                return "Login";
            }
        } else {
            model.addAttribute("message", "Invalid email or password");
            return "Login";
        }
    }


    @PostMapping("verify")
    public String verifyOtp(String email, String otp, Model model) {
        System.out.println("Running in the verifyOtp method");
        boolean isValid = rapidoService.verifyOtp(email, otp);
        if (isValid) {
            model.addAttribute("message", "OTP Verified Successfully!");
            return "SetPassword";
        } else {
            model.addAttribute("message", "Invalid or Expired OTP. Please try again.");
            return "VerifyOtp";
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("profile") String profile,
                         HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg"); // or image/png if PNG

        File file = new File("D:\\SaveMe\\" + profile);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try (InputStream in = new BufferedInputStream(new FileInputStream(file));
             ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        }
    }


    @PostMapping("setPassword")
    public String setPassword(RapidoDto rapidoDto, Model model) {
        System.out.println("Running in the setPassword method");
        return "Login";
    }


}


//package com.xworkz.rapido.controller;
//
//import com.xworkz.rapido.dto.RapidoDto;
//import com.xworkz.rapido.entity.RapidoEntity;
//import com.xworkz.rapido.service.RapidoService;
//import com.xworkz.rapido.service.RapidoServiceImplementation;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Controller
//@RequestMapping("/")
//public class RapidoController {
//    @Autowired
//    RapidoService rapidoService;
//    @Autowired
//    RapidoServiceImplementation rapidoServiceImplementation;
//
//
//    public RapidoController() {
//        System.out.println("Running in the RapidoController controller ");
//    }
//
//
//    @GetMapping("login")
//    public String login() {
//        System.out.println("Running in the login Method in GetMapping");
//        return "Login";
//    }
//
//    @GetMapping("regi")
//    public String Register() {
//        System.out.println("Running in the Register Method in GetMapping");
//        return "Register";
//    }
//
//    @PostMapping("register")
//    public String handleRegister(RapidoDto rapidoDto, Model model) {
//        System.out.println("Running  in the handleRegister method ");
//        System.out.println("Processing Register Post Request: " + rapidoDto);
//        // model.addAttribute("rapidoDto", rapidoDto);
//        Boolean rapidoDto1 = rapidoService.save(rapidoDto);
//        if (rapidoDto1) {
//            System.out.println("SavedSuccessfully");
//            model.addAttribute("message", "***************SavedSuccessfully***************");
//            return "VerifyOtp";
//        } else {
//            System.out.println("Failed To save");
//
//            return "Register";
//        }
//    }
//
//    @PostMapping("log")
//    public String handleLogin(RapidoDto rapidoDto, Model model) {
//        System.out.println("Running in the handleLogin method");
//
//        RapidoDto entity = rapidoService.findByEmail(rapidoDto.getEmail());
//
//        if (entity != null && new BCryptPasswordEncoder().matches(rapidoDto.getPassword(), entity.getPassword())) {
//
//            String filename = null;
//            try {
//                byte[] bytes = rapidoDto.getProfilePicture().getBytes();
//                Path path = (Path) Paths.get("D:\\File Folder\\" + rapidoDto.getName() + System.currentTimeMillis());
//                Files.write(path, bytes);
//                filename = (path).getFileName().toString();
//                System.out.println("Uploaded file saved as: " + filename);
//                model.addAttribute("name", rapidoDto.getName());
//                model.addAttribute("filename", filename);
//
//                return "LoginSuccessfull";
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                model.addAttribute("dto", rapidoDto);
//                model.addAttribute("message", "File upload failed");
//                return "Login";
//            }
//
//
//
//
//        } else {
//            model.addAttribute("message", "Invalid email or password");
//            return "Login";
//        }
//    }
//
//    @PostMapping("verify")
//    public String verifyOtp(String email, String otp, Model model) {
//        System.out.println("Running in the verifyOtp method ");
//        boolean isValid = rapidoService.verifyOtp(email, otp);
//        if (isValid) {
//            model.addAttribute("message", "OTP Verified Successfully!");
//            return "SetPassword";
//        } else {
//            model.addAttribute("message", "Invalid or Expired OTP. Please try again.");
//            return "VerifyOtp";
//        }
//    }
//
//    @PostMapping("setPassword")
//    public String setPassword(RapidoDto rapidoDto,Model model) {
//        System.out.println("Running in the setPassword in postMapping ");
//        return "Login";
//
//    }
//
//
//@GetMapping("/download")
//public void download(@RequestParam("profile") String profile, HttpServletResponse response) throws IOException {
//    System.out.println("profile: " + profile);
//    response.setContentType("image/jpg");
//    File file = new File("D:\\File Folder\\" + profile);
//    System.out.println(profile);
//    InputStream in = new BufferedInputStream(new FileInputStream(file));
//    ServletOutputStream out = response.getOutputStream();
//    IOUtils.copy(in, out);
//    response.flushBuffer();
//
//}
//}