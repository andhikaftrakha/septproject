package com.rmit.sept.tues630.group3.majorproject.web;


import com.rmit.sept.tues630.group3.majorproject.model.Account;
import com.rmit.sept.tues630.group3.majorproject.services.CustomerService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class accountController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "")
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody Account account, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }
        Account account1 = customerService.saveOrUpdateAccount(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> loginAccount(@RequestBody String request) {
        JSONObject param = null;
        Map<String, String> respon = new HashMap<String, String>();
        HttpStatus status = HttpStatus.OK;
        try {
            param = new JSONObject(request);
            String username = param.get("username").toString();
            String password = param.get("password").toString();
            System.out.println("username : "+username+" password : "+password );
            Account account1 = customerService.findByUsername(username);
            System.out.println("Account :"+account1);
//            Account account1 = customerService.findByUsername(username);
            if(account1 != null) {
                if(password.equals(account1.getPassword())) {
                    respon.put("status", "success");
                    respon.put("message", "success");
                    status = HttpStatus.OK;
                }else{
                    respon.put("status", "fail");
                    respon.put("message", "Password Salah");
                    status = HttpStatus.BAD_REQUEST;
                }

            }else{
                respon.put("status", "fail");
                respon.put("message","Account tidak ditemukan");
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, String>>(respon, status);
    }
}
