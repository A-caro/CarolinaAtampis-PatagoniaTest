package com.example.loanservice.service;


import com.example.loanservice.entity.Loan;
import com.example.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    public Loan save(Loan loan){
        Loan newloan = loanRepository.save(loan);
        return newloan;
    }

    public Optional<Loan> getClientId(int id){
        return loanRepository.findById(id);
    }

    public List<Loan> getAll(){
        return loanRepository.findAll();
    }


}
