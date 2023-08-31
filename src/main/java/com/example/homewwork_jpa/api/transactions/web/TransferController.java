package com.example.homewwork_jpa.api.transactions.web;

import com.example.homewwork_jpa.api.transactions.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<?> transfer(@RequestBody CreateTransactionDto createTransactionDto){
        transferService.transaction(createTransactionDto);
        return ResponseEntity.ok("Success");

    }
}
