package com.example.demo1.controller;

import com.example.demo1.Models.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "api/v1/FileUpLoad")
public class FileUploadController {
    //this controller receive images from client
    @PostMapping("")
    public ResponseEntity<ResponseObject> upLoadFile(@RequestParam("file")MultipartFile file){
        try {
            //sdjn
        }catch(Exception e){

        }

        return null;
    }
}
