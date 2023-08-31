package com.example.homewwork_jpa.api.transactions.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTransactionDto(@NotBlank(message = "StudentNo is required!")
                                   String studentCardNo,
                                   @NotNull(message = "Amount is required!")
                                   Integer amount,
                                   @NotNull(message = "Sender Account is required!")
                                   Integer senderAccountId,
                                   @NotNull(message = "Receiver Account is required!")
                                   Integer receiverAccountId,
                                   @NotBlank(message = "Remark is required!")
                                   String remark
                                   ) {
}
