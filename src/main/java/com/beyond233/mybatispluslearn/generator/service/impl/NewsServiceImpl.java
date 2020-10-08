package com.beyond233.mybatispluslearn.generator.service.impl;

import com.beyond233.mybatispluslearn.generator.entity.News;
import com.beyond233.mybatispluslearn.generator.mapper.NewsMapper;
import com.beyond233.mybatispluslearn.generator.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author beyond233
 * @since 2020-07-11
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
