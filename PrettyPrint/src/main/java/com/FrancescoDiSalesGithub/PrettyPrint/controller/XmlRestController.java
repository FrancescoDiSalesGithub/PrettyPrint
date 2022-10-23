package com.FrancescoDiSalesGithub.PrettyPrint.controller;

import com.FrancescoDiSalesGithub.PrettyPrint.xml.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlRestController
{
    @Autowired
    XmlService xmlService;

    @PostMapping("/xml")
    public ResponseEntity<String> xml(@RequestBody Object object)
    {
        String content = xmlService.printFromContent(object);
        ResponseEntity<String> response = new ResponseEntity<>(content, HttpStatus.ACCEPTED);
        return response;
    }
}
