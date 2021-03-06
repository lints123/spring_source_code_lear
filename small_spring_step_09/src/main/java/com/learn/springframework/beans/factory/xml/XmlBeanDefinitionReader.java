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

import java.io.InputStream;

/**
 * @author lints
 * @Date 2022/5/5
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
    public void loadBeanDefinition(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinition(resource);
    }

    @Override
    public void loadBeanDefinition(String... locations) throws BeansException {
        for (String location : locations) {
            ResourceLoader resourceLoader = getResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            loadBeanDefinition(resource);
        }
    }

    @Override
    public void loadBeanDefinition(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);

        }
    }

    @Override
    public void loadBeanDefinition(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinition(resource);
        }
    }

    /**
     * ?????????????????????
     * @param inputStream
     * @throws ClassNotFoundException
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // ??????Xml??????
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();

        // ??????XML
        // ???????????????
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (!(item instanceof Element)) {
                continue;
            }

            // ??????bean??????
            if (!"bean".equals(item.getNodeName())) {
                continue;
            }

            // ????????????
            Element bean = (Element) item;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            //
            String beanScope = bean.getAttribute("scope");

            // ??????ClassName???????????????
            Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isNotBlank(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // ??????BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                // ??????
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }

                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }

                // ????????????
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                // ????????????
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            // ????????????
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            // ?????????BeanDefinition???
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
