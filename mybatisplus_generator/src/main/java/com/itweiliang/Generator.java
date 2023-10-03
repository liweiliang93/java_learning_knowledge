package com.itweiliang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * @author liweiliang
 * @create 2023-07-02 20:33:44
 * @description 代码生成器:尝试生成一个自己的代码格式
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        //设置数据源
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatisplus_db");
        dataSource.setUsername("root");
        dataSource.setPassword("liang521..");
        autoGenerator.setDataSource(dataSource);

        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/mybatisplus_generator/src/main/java");
        globalConfig.setAuthor("liweiliang");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setMapperName("%sMapper");
        autoGenerator.setGlobalConfig(globalConfig);

        //设置报名和相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.itweiliang");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("dao");
        autoGenerator.setPackageInfo(packageConfig);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix("tb_");
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setVersionFieldName("version");
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}