package top.zhanganzhi.gpacalculator.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.zhanganzhi.gpacalculator.module.Subject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ResourcesLoader {
    private static final ResourcesLoader instance = new ResourcesLoader();
    private final ApplicationProperties applicationProperties;
    private final LetterGradeMap letterGradeMap;
    private final SubjectList subjectList;

    private ResourcesLoader() {
        applicationProperties = new ApplicationProperties(loadApplicationPropertiesResource());
        letterGradeMap = new LetterGradeMap(loadLetterGradeMapResource());
        subjectList = new SubjectList(loadSubjectListResource());
    }

    public static ResourcesLoader getInstance() {
        return instance;
    }

    private Properties loadApplicationPropertiesResource() {
        InputStream in = Tool.readFileAsStream("META-INF/application.properties");
        var applicationPropertiesResource = new Properties();
        try {
            applicationPropertiesResource.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return applicationPropertiesResource;
    }

    private JSONObject loadLetterGradeMapResource() {
        return JSON.parseObject(Tool.readFileAsString("letterGradeMap.json"));
    }

    private JSONObject loadSubjectListResource() {
        return JSON.parseObject(Tool.readFileAsString("subjectList.json"));
    }

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }

    public LetterGradeMap getLetterGradeMap() {
        return letterGradeMap;
    }

    public SubjectList getSubjectList() {
        return subjectList;
    }
}
