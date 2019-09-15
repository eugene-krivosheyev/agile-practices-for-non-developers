package com.acme.dbo.account.dao;

import com.acme.dbo.account.domain.Account;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;

@ConditionalOnProperty(name = "features.account", havingValue = "true", matchIfMissing = true)
public interface AccountRepository extends JpaRepository<Account, Long> {
}
