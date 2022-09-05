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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends StudyApplicationTests {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

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
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                Item item = detail.getItem();
                System.out.println(detail.getItem());     //order_detail의 item_id를 출력
            });

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

}
