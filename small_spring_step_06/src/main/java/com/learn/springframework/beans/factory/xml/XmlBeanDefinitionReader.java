package com.learn.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.learn.springframework.beans.BeansException;
import com.learn.springframework.beans.PropertyValue;
import com.learn.springframework.beans.factory.config.BeanDefinition;
import com.learn.springframework.beans.factory.config.BeanReference;
import com.learn.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.learn.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.learn.springframework.core.io.Resource;
import com.learn.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Struct;

/**
 * @author lints
 * @Date 2022/4/1
 * @Descirption
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    // 根据加载BeanDefinition
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            ResourceLoader resourceLoader = getResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            loadBeanDefinitions(resource);
        }
    }


    /**
     * 加载Xml配置文件，解析Xml配置，加载到BeanDefinition中
     *
     * @param inputStream
     * @throws ClassNotFoundException
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // 加载XML文件
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();

        // 解析XML
        // 获取子节点
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }

            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //返回class对象的引用。
            Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 加载BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            // 是否存在属性
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {

                // 是否是节点
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }

                // 是否为属性
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                // TODO 第二次犯错，获取属性，这里之前写 i , 直接获取到首个节点，也就是Bean上面去了。
                // TODO 错误案例：(Element) bean.getChildNodes().item(i);
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                // 可能为值也可能为对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                // 保存属性
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            // 校验是否存在
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            // 注册BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);

        }

    }


}
