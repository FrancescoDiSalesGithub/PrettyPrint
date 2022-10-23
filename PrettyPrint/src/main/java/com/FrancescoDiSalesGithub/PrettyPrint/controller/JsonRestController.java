package com.FrancescoDiSalesGithub.PrettyPrint.controller;

import com.FrancescoDiSalesGithub.PrettyPrint.json.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRestController
{
    @Autowired
    JsonService jsonService;

    @PostMapping("/json")
    public ResponseEntity<String> prettyJson(@RequestBody Object object)
    {
        String responseBody = jsonService.printFromContent(object);
        ResponseEntity<String> response = new ResponseEntity<>(responseBody,HttpStatus.ACCEPTED);

        return  response;
    }


}
