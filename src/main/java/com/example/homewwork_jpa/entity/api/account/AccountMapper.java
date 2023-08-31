package com.example.homewwork_jpa.entity.api.account;

import com.example.homewwork_jpa.entity.api.account.web.AccountDto;
import com.example.homewwork_jpa.entity.api.account.web.CreateAccountDto;
import com.example.homewwork_jpa.entity.api.account.web.UpdateAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto mapAccountToAccountDto(Account account);

    List<AccountDto> mapAccountToAccountDtoList(List<Account> accounts);
    Account createAccount(CreateAccountDto createAccountDto);

    Account updateAccountDtoToAccount(UpdateAccountDto updateAccountDto);




}
