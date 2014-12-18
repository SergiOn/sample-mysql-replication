package com.github.nagaseyasuhito.sample.mysql.replication.entity;

import com.github.nagaseyasuhito.sample.mysql.replication.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class UserIT {
    @Autowired
    UserRepository userRepository;
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setName("name");
        user.setPassword("password");
        userRepository.save(user);
    }

    @Test
    public void testFind() throws Exception {
        Optional<User> opt = userRepository.findByName("name");
        assertThat(opt.isPresent(), is(true));
        opt.ifPresent(u -> assertThat(u, is(user)));
    }
}
