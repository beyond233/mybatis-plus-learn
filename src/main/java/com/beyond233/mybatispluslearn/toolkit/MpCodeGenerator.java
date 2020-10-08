package com.beyond233.mybatispluslearn.toolkit;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import net.sf.jsqlparser.schema.Table;

import java.util.ArrayList;

/**
 * <p>项目文档: MP CodeGenerator</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-05 20:14
 */
public class MpCodeGenerator {
    public static void main(String[] args) {
        //1.构建AutoGenerator对象
        AutoGenerator generator = new AutoGenerator();

        //2.配置生成策略
        //2.1全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectDir = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectDir + "/src/main/java");
        globalConfig.setAuthor("beyond233");
        globalConfig.setOpen(false);
        //是否覆盖
        globalConfig.setFileOverride(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setIdType(IdType.ID_WORKER);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        //保存全局设置到生成器中
        generator.setGlobalConfig(globalConfig);

        //2.2设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/his?useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);
        //保存数据源设置到生成器中
        generator.setDataSource(dataSourceConfig);

        //2.3包的设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setService("service");
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setModuleName("generator");
        packageConfig.setParent("com.beyond233.mybatispluslearn");
        //保存包设置到生成器中
        generator.setPackageInfo(packageConfig);

        //2.4 策略配置
        StrategyConfig strategy= new StrategyConfig();
        //设置要映射的表名
        strategy.setInclude("department","news");
        //开启驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //使用lombok自动注解实体类
        strategy.setEntityLombokModel(true);
        //设置逻辑删除的数据库字段名
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        //设置乐观锁对应的数据库字段名
        strategy.setVersionFieldName("version");
        //开启Restful风格Controller，如localhost
        strategy.setRestControllerStyle(true);
        //保存策略配置到生成器中
        generator.setStrategy(strategy);

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //3.执行
        generator.execute();
    }
}
