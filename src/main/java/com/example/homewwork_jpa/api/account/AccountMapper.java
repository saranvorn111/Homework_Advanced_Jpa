package com.example.homewwork_jpa.api.account;

import com.example.homewwork_jpa.api.account.web.AccountDto;
import com.example.homewwork_jpa.api.account.web.CreateAccountDto;
import com.example.homewwork_jpa.api.account.web.ChangeTransferLimitAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto mapAccountToAccountDto(Account account);

    List<AccountDto> mapAccountToAccountDtoList(List<Account> accounts);
    Account createAccount(CreateAccountDto createAccountDto);

    Account updateAccountDtoToAccount(ChangeTransferLimitAccountDto updateAccountDto);




}
