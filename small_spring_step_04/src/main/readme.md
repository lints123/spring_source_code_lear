# 属性注入和依赖对象
- 通过BeanDefinition配置PropertyValues值,来存储对象所需要的属性，如果有存在对象注入，那么讲该对象对应的BeanName存储到BeanReference中。
- 定义PropertiesValues类，集合PropertyValue，而PropertyValue存储属性名和属性值。
