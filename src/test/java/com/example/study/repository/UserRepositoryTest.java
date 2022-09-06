package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends StudyApplicationTests {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTER";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        assertNotNull(user);
    }

/*
    @Test
    @Transactional
//    public void read(@RequestParam Long id) {
    public void read() {

        // SELECT * FROM user WHERE id = ?
//        Optional<User> user = userRepository.findById(7L);
        Optional<User> user = userRepository.findByAccount("TestUser03");

        //2L 유저 있으면 출력
        user.ifPresent(selectUser -> {
            
            // 1:N 관게 아이템을 foreach돌아서 출력
//            selectUser.getOrderDetailList().stream().forEach(detail -> {
//                Item item = detail.getItem();
//                System.out.println(detail.getItem());     //order_detail의 item_id를 출력
//            });

//            System.out.println("user : " + selectUser);
//            System.out.println("email : " + selectUser.getEmail());
        });

    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);

        });
    }

//    @DeleteMapping("/api/user")
    @Test
    @Transactional      // 다시 롤백됨
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

//        Assert.assertTrue(user.isPresent());  //legacy
        assertTrue(user.isPresent());   //false

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        //for test
//        if(deleteUser.isPresent()) {
//            System.out.println("데이터 존재 : " + deleteUser.get());
//        } else {
//            System.out.println("데이터 삭제 데이터 없음");
//        }

//        Assert.assertFalse(deleteUser.isPresent());   //legacy
        assertTrue(deleteUser.isPresent()); //false

    }
*/
}
