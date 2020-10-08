package com.beyond233.mybatispluslearn;

import com.beyond233.mybatispluslearn.generator.entity.News;
import com.beyond233.mybatispluslearn.generator.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-05 21:44
 */
@SpringBootTest
public class NewsServiceTest {
    @Autowired
    private NewsService newsService;

    @Test
    public void test(){
        News news = newsService.getById(1);
        System.out.println(news);
    }

}
