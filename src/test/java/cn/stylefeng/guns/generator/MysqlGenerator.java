package cn.stylefeng.guns.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

/**
 * @Copyright 成都可迅捷科技有限公司
 * @ClassName MysqlGenerator
 * @Description 代码生成
 * @Author kangdong
 * @Date 2019/4/16 14:55
 * @Version 1.0
 **/
public class MysqlGenerator {

    /**
     * RUN THIS
     *
     * 会多生成一个 iService接口 ,需要删除
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //设置模板引擎
        mpg.setTemplateEngine(new BeetlTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        //下面setOutputDir（）方法动态获取了路径，这里就不用了
//        gc.setOutputDir("F:\\kexunjie\\space\\zhuanzhuan_app\\src\\main\\java");//输出文件路径
//        gc.setOutputDir("F:\\kexunjie\\workspace\\kexunjie\\zhuanzhuan_app\\src\\main\\java");//输出文件路径


        //当前程序所在目录
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java");//输出文件路径 动态获取

        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("baoruizhe");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        //gc.setServiceName("I%sService");
        gc.setServiceImplName("%sService");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/guns?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

        strategy.setInclude(new String[] { "sys_XXX"}); // 需要生成的表

        strategy.setEntityLombokModel(true);//【实体】是否为lombok模型
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.stylefeng.guns.modular.system");
        pc.setController("controller");
//        pc.setService(null);
        pc.setServiceImpl("service");//pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mapper.mapping");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}
