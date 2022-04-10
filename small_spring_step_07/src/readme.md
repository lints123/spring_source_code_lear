# 新增初始化方法和销毁方法
- gitee网址：https://gitee.com/small-spring/small-spring-step-07/tree/main

## 初始化方法
实现有两种，一种是XML配置，一种是接口的方式。
XML配置，主要声明init-method方法，在创建BeanDefinition的时候，解析XML配置之后存到BeanDefinition中。后面在创建Bean的时候调用。
也就是在**创建Bean之前调用初始化方法**。
具体调用：AbstractAutowriteCapableBeanFactory > createBean > initializeBean > invokeInitMethods 执行。

## 销毁方法
同上，有个区别在于，声明销毁**destroySingletons**的方法在ConfigurableBeanFactory接口, 通过AbstractBeanFactory实现接口，但是这里有个区别在于，实际上实现**destroySingletons**在DefaultSingletonBeanRegistry类。
> 关系是: AbstractBeanFactory继承DefaultSingletonBeanRegistry和实现ConfigurableBeanFactory接口，但是在ConfigurableBeanFactory接口声明的方法，可以被DefaultSingletonBeanRegistry实现。
> 简单说，当一个类继承了A类和实现B接口的时候，A类可以实现B接口的方法。 

具体调用：applicationContext.registerShutdownHook();

## 具体操作的类
### XML配置使用
1. XML配置文件，配置init-method、destroy-method，同时实现类中要定义具体的方法
2. BeanDefinition新增字段initMethodName、destroyMethodName
3. XmlBeanDefinitionReader解析XML配置文件的时候，对新增的字段initMethodName、destroyMethodName进行赋值。

### 使用接口进行初始化和销毁
1. 声明接口：InitializingBean、DisposableBean
2. 声明实现类：业务实现类都可
3. 定义方法执行：applicationContext.registerShutdownHook();
4. 销毁方法有个地方是比较意外的。看上面销毁方法的解释