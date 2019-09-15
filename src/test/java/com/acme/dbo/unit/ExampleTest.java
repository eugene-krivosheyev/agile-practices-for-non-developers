package com.acme.dbo.unit;

import com.acme.dbo.account.dao.AccountRepository;
import com.acme.dbo.account.domain.Account;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.*;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class ExampleTest {
    @MockBean private AccountRepository accountRepository;

    @Test
    public void exampleTest() {
        given(accountRepository.findById(0L)).willReturn(Optional.of(new Account()));
        assertThat("demo string").contains("demo");
        verify(accountRepository, times(0)).findById(anyLong());
    }
}
