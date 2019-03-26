package com.test.service;

import com.test.entity.UserEntity;
import com.test.repository.UserRepository;
import com.test.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserAgeAfterNumber() {

        List<UserEntity> expected = new ArrayList<>();

        for (int i = 7; i < 11; i++) {
            UserEntity user = new UserEntity();
            user.setName("User" + i);
            user.setAge(16 + i);
            expected.add(user);
        }

        when(userRepository.findByAgeAfter(22)).thenReturn(expected);

        List<UserEntity> users = userService.findByAgeAfterNumber(22);
        verify(userRepository).findByAgeAfter(22);

        Assert.assertEquals(expected, users);
    }

    @Test
    public void testSave() {


    }
}
