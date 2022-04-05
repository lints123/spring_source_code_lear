实现应用上下文。主要是定义接口，来实现注册Bean之后的修改，和实例化Bean之后的扩展
- BeanFactoryPostProcess：前置处理器，对BeanDefinition内容进行修改
- BeanPostProcessor：后置处理器，实例化Bean之后，对Bean的内容进行扩展。
> https://bugstack.cn/md/spring/develop-spring/2021-06-17-%E7%AC%AC7%E7%AB%A0%EF%BC%9A%E6%89%80%E5%90%91%E6%8A%AB%E9%9D%A1%EF%BC%8C%E5%AE%9E%E7%8E%B0%E5%BA%94%E7%94%A8%E4%B8%8A%E4%B8%8B%E6%96%87%EF%BC%8C%E8%87%AA%E5%8A%A8%E8%AF%86%E5%88%AB%E3%80%81%E8%B5%84%E6%BA%90%E5%8A%A0%E8%BD%BD%E3%80%81%E6%89%A9%E5%B1%95%E6%9C%BA%E5%88%B6.html#%E4%B8%89%E3%80%81%E8%AE%BE%E8%AE%A1

Spring源码解析有几个方面。
1. 从BeanFactory接口，定义出具体创建Bean的方法。
2. 再有AbstractoryBeanFactory去实现，通过doGetBean组装模板方法，声明创建Bean的步骤。
    1. 具体有从单例获取对象，获取不到则创建BeanDefinition（Bean的定义，这里有两种创建方法，JDK反射或者Cglib反射）而这里的创建，使用了策略模式。
    2. 实现BeanDefinition的方法，具体类DefaultListableBeanFactory

3. 对BeanDefinition进行封装。通过PropertiesValues对properties进行封装。

4. 封装上下文处理，定义ApplicationContext抽象类，继承ListableFactory，避免类直接暴露，通过上下文的方式进行封装。

5. 封装前置和后置处理器处理

![test](G:\框架\spring_source_code_lear\small_spring_step_06\src\image\context.jpg) 

# 犯错教训
1. XmlBeanDefinitionReader类中，读取xml并且加载到BeanDefinition中，j写成i导致报错。
   - // TODO 第二次犯错，获取属性，这里之前写 i , 直接获取到首个节点，也就是Bean上面去了。
   - // TODO 错误案例：(Element) bean.getChildNodes().item(i); 应该写bean.getChildNodes().item(j);

# 总结
敲代码不难，难的是理解人家怎么做，为什么这么做，这样做有什么好处的思想。