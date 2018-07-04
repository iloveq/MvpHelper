# MvpHelper
简书地址：https://www.jianshu.com/p/47509e1684a1

##### Google官方安卓Mvp架构demo
https://github.com/googlesamples/android-architecture

```
todo-mvp: 基础的MVP架构。
todo-mvp-loaders:基于MVP架构的实现，在获取数据的部分采用了loaders架构。
todo-mvp-databinding: 基于MVP架构的实现，采用了数据绑定组件。
todo-mvp-clean: 基于MVP架构的clean架构的实现。
todo-mvp-dagger2: 基于MVP架构，采用了依赖注入dagger2。
dev-todo-mvp-contentproviders: 基于mvp-loaders架构，使用了ContenPproviders。
dev-todo-mvp-rxjava: 基于MVP架构，对于程序的并发处理和数据层（MVP中的Model）的抽象。
```

##### idea插件论坛
https://intellij-support.jetbrains.com/hc/en-us/community/topics/200366979-IntelliJ-IDEA-Open-API-and-Plugin-Development

因为对mvp的理解不同，会有很多种方式表达架构，所以插件要极简易读，可扩展性强，所以可以选择：
```
/**
     * 通过模板生成类
     * @param var1 文件生成路径
     * @param var2 文件名
     * @param var3 模板名
     * @param var4 是否生产类
     * @param var5 模板参数
     */
public abstract PsiClass createClass(@NotNull PsiDirectory var1, @NotNull String var2, @NotNull String var3, boolean var4, @NotNull Map<String, String> var5) throws IncorrectOperationException;

```
也就是只要定制不同的模板就可以实现扩展性

##### 具体使用定制自己的插件，见简述使用方法 ：)


