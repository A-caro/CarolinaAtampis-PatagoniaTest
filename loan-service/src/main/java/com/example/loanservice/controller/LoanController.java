package com.example.loanservice.controller;

import com.example.loanservice.entity.Loan;
import com.example.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("/All")
    public List<Loan> getAll(){
        return loanService.getAll();
    }

    @PostMapping()
    public Loan save(@RequestBody Loan loan){
        return loanService.save(loan);
    }

    @GetMapping("/byclient/{id}")
    public Optional<Loan> getClientId(@PathVariable("id") int id){
        return loanService.getClientId(id);
    }



}
