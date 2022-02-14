# 实现Bean的定义、注册、获取
- 之前是直接实例化Bean,然后存储到缓存中进行获取。这次将Bean的实例化交给容器去创建。调用的时候只传递具体的Bean名称。

## 具体类
定义创建Bean实例和模板方法
- BeanFactory: 定义getBean
- AbstractBeanFactory：定义模板方法getBean，同时声明getBeanDefinition和createBean抽象方法。
- AbstractAutowireCapableBeanFactory: 抽象类,实现方法createBean
- **DefaultListableBeanFactory**: 核心类, 实现方法getBeanDefinition, 同时实现接口BeanDefinitionRegistry, 注册当前对象信息到BeanDefinitionMap中。

定义单例
- SingletonBeanRegistry：声明注册单例Bean接口
- DefaultSingltonBeanRegistry: 实现类，实现SingletonBeanRegistery, 通过缓存存储单例Bean

定义BeanDefinition
- BeanDefinitionRegistery: 声明注册BeanDefinitionRegistery接口
- DefaultListableBeanFactory：核心类实现，实现方法registerBeanDefinition，将BeanDefinition放到缓存中。

## 拆分
将Bean的定义、注册、实现分为3个步骤
1. 声明Bean的实现，即从单例缓存中获取Bean，获取不到再创建，创建则先获取BeanDefinition,之后进行实例化再放到缓存(这里少了一步依赖注入) 
2. 声明实现Bean的类型，即单例
3. 声明Bean的对象信息，即BeanDefinition

## 画图
看DefaultListableBeanFactory，按Ctrl+Alt+U 查看UML结构图。
