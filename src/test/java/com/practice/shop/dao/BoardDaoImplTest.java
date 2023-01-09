package com.practice.shop.dao;


import com.practice.shop.domain.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    private BoardDao boardDao;
    @Test
    public void insert()throws Exception {
//        for(int i = 10; i < 100; i++){
//            BoardDto boardDto = new BoardDto(i,"asdf","title"+i,"non-content");
//            boardDao.insert(boardDto);
//            assertTrue(boardDao.insert(boardDto)==1);
//        }
    }

    @Test
    public void delete() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void select() {
    }
}