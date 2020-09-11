package com.rocksea.security;

import com.rocksea.common.TimeProvider;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PasswordEncodingTest {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void shouldBeTestPasswordSame() throws Exception{
        TimeProvider timeProviderMock = mock(TimeProvider.class);
        Date beforeSomeTime = new Date(DateUtil.now().getTime()-10000);
        when(timeProviderMock.now())
                .thenReturn(beforeSomeTime);

        System.out.println(DateUtil.now());
        System.out.println(timeProviderMock.now());

        String encodedPassword = passwordEncoder.encode("123");
        assertThat(passwordEncoder.matches("123",encodedPassword)).isTrue();
        assertThat(passwordEncoder.matches("1234",encodedPassword)).isFalse();
    }
}
