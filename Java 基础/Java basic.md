# 一、 java编程规范

- 命名不能以下划线_或美元符$开始或结束。
- 不允许使用拼音和英文混用命名。
- 类名中每个单词首字母大写，即UpperCamelCase风格。
- 方法名、参数名、成员变量、局部变量统一使用lowerCamelCase风格。
- 常量命名全部大写，单词间用_分隔。
- 抽象类以Abstract或Base开头；异常类以Exception结束；测试类以被测试的类名开头，以Test结尾。
- POJO类中的布尔类型的变量都不要加is前缀，否则解析时会发生序列化错误。
- 包名中每一个单词小写，“.”分隔的域，有且只有一个单词，且单词用单数形式。
- 杜绝不规范的缩写。
- 命名的单词组合尽量用完整的单词拼写。
- 如果模块、接口、类、方法使用了设计模式，应再命名是提现出具体的模式。
- 接口类中的方法和属性不要使用任何修饰符，保持代码的简洁性，并加上有效的Javadoc注释，尽量不要在接口里定义变量，除非特例。
- 接口和实现类的密码有两套规则
>- 对于Service和DAO类，基于SOA的理念，暴露出来的服务一定是接口，内部的实现类用Impl后缀与接口区别。
>- 如果是形容能力的接口名称，取对应的形容词。
枚举类名建议带上Enum后缀，枚举成员名称需要全大写，单词间用“_”分隔。
- 各层命名规则
>- Service和DAO层，命名规则如下：
> 1. 获取单个对象用get作为前缀
> 2. 获取多个对象用list作为前缀
> 3. 获取统计值的方法用count作为前缀
> 4. 插入方法用save/insert作为前缀
> 5. 删除的方法用remove/delete作为前缀
> 6. 修改的方法用update作为前缀
>- 领域模型命名规约如下：
> 1. 数据对象：xxxDO，xxx作为数据表名
> 2. 数据传输对象：xxxDTO，xxx为业务领域相关的名称
> 3. 展示对象：xxxVO，xxx一般为网页名称
> 4. POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO

# 二、java面向对象

> java是一种纯的面向对象语言

## 1. 面向对象初级

> 主要介绍抽象、类、对象、属性、方法以及一些修饰符

### 1.1 抽象的含义
抽象（abstraction）是从被研究的对象中舍弃个别的、非本质的或与研究主旨无关的特征，而抽取与研究有关的共性内容加以考察，形成对研究问题正确、简明扼要的认识。
### 类与对象
对象是对客观事物的抽象，类是对对象的抽象。定义一个类：

```java
public class ClassName{
}
```
类和对象的关系：

> 类是对象的模板，对象是类的实例。

类似于：类是DNA，而对象是具有该DNA的实体。因而，类只能有一个，对象可以有成千上万个。

### 1.2 类的域（属性）与方法（操作）
定义属性：

**类型 域变量名**

定义方法：

**[修饰符] 返回值类型 方法名（参数类型 参数1，[参数类型 参数2]...）{**
    **方法体**
**}**

类中的域变量与方法的关系：
- 类的方法可以访问所有的域变量 
- 方法的参数和方法内的局部变量作用域仅限于方法，局部变量在使用前必须进行赋值初始化。
- 类中的方法可以是递归方法。

### 1.3 对象
#### 1.3.1 对象的创建
```java
//定义一个类
public class Student{
    String name;
    String sex;
    
    Student(){
        
    }
    
    public String getName(){
        return name;
    }
    
    public String getSex(){
        return sex;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSex(String sex){
        this.sex = sex;
    }
}

//声明并实例化一个对象
Student strdent = new Strdent();
//student1并没有被实例化，是一个Null Point
Student student1;
```

声明并实例化一个对象的隐含信息：
- 对象实例化了之后，从类中复制了属性和方法
- 对象调用方法时，方法内的局部变量和参数存放在栈中

> java的内存模型，包括堆和栈。类和对象(实例化后)被分配到堆中，方法执行时用的局部变量和形式参数则放到栈空间中。
> C++ 中用new产生的对象在堆中，下面的:
> ```c
> Student student;//该对象存放于栈中
> ```

#### 1.3.2 对象作为参数的特点
- 基本数据类型作为参数在方法中的传递是值传递
- 对象是引用传递，传递的是地址，对对象属性进行修改，会影响其他程序对对象的使用。一维数组和二维数组也是引用传递。
#### 1.3.3 可以像创建基本类型的数组一样，创建对象数组。
> 对象数组指每一个元素都是一个对象。
#### 1.3.4 数组对象特点及常用方法
> 数组对象指数组整体上可以看成一个对象（java集合类中的ArrayList, List等），**具有引用传递的特点**。数组有一个length属性，指当前纬度的长度。

对象数组应用时须注意以下几点：
- Java集合类可以调用相应的方法返回对象数组引用，例如：linkedList、Vector等的toArray()方法返回```Object[]```数组引用。
- ```System.arraycopy()```方法可复制数组。
- java中有类```Arrays```,其方法```sort```可针对```char、byte、short、int、float、double、long```等按照升序排列，也可指定比较器，对对象数组进行排序。
### 1.4 构造方法
> 构造方法是类中的一个类名相同类型的类方法。**构造方法专属于类，不属于由该类实例化的对象**

**构造方法的特征：**
- 方法名与类名一致，当用```new```创建实例时，系统会自动调用类的构造方法。
- 不能对构造方法指定返回值类型，它有隐含的返回值，返回值供JVM使用。
- 构造方法具有多态性，构造方法可以重载，根据传入参数自动调用相应的重载方法。
- 系统会为没有定义构造方法的类，添加一个默认的无参数的空的构造方法
- 对于用于域变量初始化的构造函数，参数名和属性名同名时，构造方法类用```this```获取域变量，或者将传入参数加上“_”前缀。

**对象的回收，```finalize```方法**
> 当内存中的一个类的实例没有对象对其进行引用时，该对象将会被JVM自动的回收（JVM GC）。
> 可以调用```System.gc()```提醒系统释放无引用的类实例资源。
### 1.5 非访问修饰符
#### 1.5.1 static 静态
static修饰的属性和方法只属于类，可以用```类名.属性```或者```类名.方法名```直接获取和调用。

**静态代码块**
```
//类中的静态代码块，在类被装载时，只被执行1次
static {
    //执行一些初始化的操作
}
```
#### 1.5.2 abstract
> 抽象类和抽象方法的修饰符
#### 1.5.3 final 最终
- 修饰方法为最终方法，子类中不能被覆盖（重写）
- 修饰类，表示为最终类，不能被继承
- 修饰属性，该属性为常量，值不能改变
- 结合```static```，该属性为类的静态常量，可以在内外部通过```类名.属性名```来调用
#### 1.5.4 native修饰的本地方法
> 用于调用其他语言的代码

- ```static final abstract public protected private等```不能修饰方法内部的变量

### 1.6 小结
- 类是对象的模版，对象是类的实例，引用是对象的名片
- 对象是被实例化的类，占据了一定的内存空间，并且位于堆内存中。
- 静态属性、静态方法和构造方法专属于类。通过```类名.属性名、方法名```来获取和调用
- 类的方法被调用，方法中的形式参数和局部变量位于为这个方法开辟的栈空间中。方法执行完成，栈空间被释放。
- 当一个对象没有任何名片（引用）时，该对象会被JVM的GC回收。

## 2. 面向对象中级
> 本部分介绍java的主要特征：封装、继承、多态。
### 2.1 封装
#### 2.1.1 封装的概念
封装是利用抽象数据类型将数据和基于数据的操作绑定在一起，数据被保存在抽象数据类型的内部，系统只有通过被授权（不同的访问控制修饰符）的操作方法才能够访问数据。

**面向对象语言的封装具有的特点**
- 数据和基于数据的操作方法构成一个统一体。
- 类的操作方法实现细节被隐藏起来，只是通过操作接口名称进行调用，操作内部变动不会影响接口的使用。

#### 2.2.2 访问控制权限 封装类的权限系统，访问控制符实现了类的封装
三大权限访问控制操作符：```public、private、protected```，可以修饰的地方：
- 修饰类
- 修饰类的域变量（属性成员）
- 修饰类的成员方法
> ```final```也可以修饰。```static```不能修饰类，可以修饰语域变量和方法。

```
graph LR
A[private]-->A1[修饰类 该类只能作为内部类 供外部类进行使用]
A-->A2[修饰成员变量 该变量只能在类内部直接使用]
A-->A3[修饰成员方法 该方法只能在类内部直接调用]
B[protected]-->B1[修饰类 除了和private一致 还可以被继承]
B-->B2[修饰成员变量 可以被同包的类和子类直接使用]
B-->B3[修饰成员方法 可以被同包的类和子类直接使用]
C[public]-->C1[修饰类 该类可以在任何地方使用 包外需要import]
C-->C2[修饰成员变量 该变量可以在任何地方使用]
C-->C3[修饰成员方法 该方法可以在任何地方调用]
```
**关于下面表格的说明**
- A: 所有的类
- B: 包中的类
- C: 所有子类
- D: 本类

修饰范围 | | 类 | 类
---|---|---|---|
 · | 修饰符域 | public | 默认 |
属性或者方法 | public  | A | B
属性或者方法 | private | B（对象引用）和C（类定义） | B
属性或者方法 | 默认 | B | B
属性或者方法 | private | D |D

#### 2.2.3 消息 
先理解java中的一些名词：
- 类：指java中定义的抽象对象。
- 对象：指类实例化后的个体，占用内存空间。
- 引用：指能操作对象的变量，类似于C++中的对象指针，类型为类、其父类、实现的接口等。

对于使用引用获取对象的```public```属性值的应用和调用```public```方法，这样的可以理解为一种消息，引用想对象发出的服务请求消息，对象给予相应的回应。
引用能否发送消息的条件：
- 引用引用的对象是否已实例化，若没有，会抛出```NullPointExecption```异常
- 类的对象，需要定义相应的属性和方法，不能为空类，否则编译不通过
- 被访问的属性和方法，必须是```public```权限控制的

**通过将不同的类组合成其他类的属性，实现类之间的组合，从而可以完成很多复杂的任务。**

> **封装与组合的设计用途**
>
> 巧妙的设计可以实现程序设计中的**高内聚、低耦合**，封装是利用访问控制符来实现的，而组合则通过对象内部的属性引用来实现。

### 2.3 继承
> extends关键词，子类继承父类，子类可以获得父类的属性和方法。**每个类只能继承一个父类。**

```
//代码示例
public class BaseClass{
    private int a;
    public int b;
    protected int c;
    
    public void setA(int a){
        this.a = a;
    }
    
    public int getA(){
        return a;
    }
    
    public void setB(int b){
        this.b = b;
    }
    
    public int getB(){
        return b;
    }
    
    public void setC(int c){
        this.c = c;
    }
    
    public int getC(){
        return c;
    }
}

public class SubClass extends BaseClass{
    private int d;
    
    public void setD(int d){
        this.d = d;
    }
    
    public int getD(){
        return d;
    }
    //会出错，没有访问权限
    public int getAAddB(){
        return a + b;
    }
    //不会出错
    public int getAAddB1(){
        return getA() + b;
    }
    //不会出错
    public int getCAddB(){
        return c + b;
    }
}

public class Test{
    public static void main(String args[]){
        BaseClass subClass = new SubClass();
        System.out.println(subClass.a);//IDE提示出错,没有权限
        System.out.println(subClass.getA());//ok
        System.out.println(subClass.b);//ok
        System.out.println(subClass.getC());//OK0
        System.out.println(subClass.c;//OK
        System.out.println(subClass.d);//IDE提示出错，没有权限
        System.out.println(subClass.getD());//OK，错，IDE提示出错，没有此方法，这个是子类特有的方法
    }
}
```
**继承的总结**
- 父类中```private```修饰的属性和变量，子类对象内部不能直接访问，父类须编写```public```修饰的方法来间接调用。
- 父类中```protected```修饰的属性和变量，子类对象内部可以直接访问，对象外部也可以直接访问。
- 父类中```public```修饰的属性和变量，可以在内部和外部直接调用。
- 父类引用子类对象，只能访问自己定义的那一部分属性和方法，无法访问子类另外定义的方法和属性。

#### 2.3.1 Object类，所有类的祖先类
> 默认继承，一个类没有父类时，默认继承Object类

**Object类的方法介绍**
- ```Object clone()``` 将当前对象克隆，深复制。
- ```boolean equals(Object obj)``` 判断两个引用是否指向同一对象，其参数不能为基本数据类型。一般子类继承了之后需要覆盖此方法。
- ```void finalize()```对象被释放时调用
- ```Class getClass()```获得当前对象的类对象。类对象 
- ```int hashCode()```得到一个代表对象的hashCode整数，对象的身份证号码。 
- ```String toString()```得到代表对象的字符串
- ```void notify()```应用于线程同步通信中唤醒一个等待线程
- ```void notifyAll()```应用于线程同步通信中唤醒全部等待线程
- ```void wait()```应用于线程同步通信的线程等待

**继承的用途**
- 继承是面向对象程序设计中对功能进行复用的重要手段
- 继承为引用带来新特点--多态，运行时确定方法

### 2.4 类的多态
> 多态是指一个程序同名但不同方法共存的情况。
> 重载指在内中定义了多个同名而须传入不同参数的成员方法。
> 覆盖指子类中，重新定义父类的方法。
> 
> **多态的设计用途**
> 多态为重用，添加了变化，让变化不会影响系统的输出。

### 2.5 小结
- 通过访问控制符修饰不同的属性和方法，实现了对数据和操作的封装。
- java继承是单继承，所有类的共同祖先是```Object```。
- 父类的声明可以应用所有子类的对象，但是只能调用父类中相应的属性和方法。
- java的多态分为重载和覆盖两种方式，重载的方法之间往往存在委托调用的关系。
- java类实例化过程是将类及其父类的属性复制到子类对象中。所有的方法调用，都只有类中的一套方法，在调用时进行动态的分配空间。

## 3. 面向对象高级
### 3.1 this 和 super
**this的用法**
- ```this.域变量、this.成员方法```用在一些命名混淆的场合，来明确哪些是域变量，哪些是成员方法。
- ```this(参数)```，调用带有参数的构造方法。
- ```this```表示当前类的对象。
> ```this```可以用来实现双向引用，两个类彼此将各自的对象作为自己的域变量。

**super的用法**
- 在子类中使用，```super.域变量、super.成员方法(参数)```获取与变量，调用成员方法。
- ```super(参数)、super()```调用父类的构造方法。
### 3.2 构造方法的多态
> 构造方法的多态主要指构造方法可以被重载，可以在本类中重载，也可以在子类中重载。
#### 3.2.1 构造方法的重载
- 多个重载的构造方法，可以相互调用，灵活的初始化域变量。
- 多个重载方法相互调用，必须使用```this(参数)```的形式。
#### 3.2.2 构造方法的继承调用
> 子类通过```super()```或```super(参数)```调用父类的不同的构造方法。

**构造方法继承遵循的原则：**
- 子类在构造函数中调用父类的构造方法时，必须位于方法体的第一句。
- 父类的构造方法只能在子类的构造方法体中调用。
- 子类的构造方法中没有调用父类的构造方法，系统默认调用父类的无参构造方法。
- 子类必须调用父类的构造方法，若父类没有无参构造方法（构造方法被重载成有参的构造方法了），子类的构造方法必须调用父类的某一个有参构造方法。
- **总结：子类必定会调用父类的构造方法，而且是在初始化本身前调用，要么默认调用父类已有的或默认生成的无参构造方法，要么显式调用某一个父类的有参构造方法。**
#### 3.2.3 子类对象的实例化过程 java笔试基础题
**子类对象实例化的步骤：**
```
graph TD
A[1. 产生对象并对对象属性进行默认初始化]-->B[2. 对构造方法中的形式参数赋值]
B-->C[3.1 存在this么]
B-->D[3.2 存在super么]
C-->E
D-->E[4. 对子类成员进行显示初始化]
E-->F[5. 执行当前构造方法体中的代码]

```
**注意**
- 显示初始化仅执行一次。
- ```this```和```super```如果存在，则位于第一句，并且他们两个不能同时存在。
- 子类用构造函数实例化时，父类先用构造函数初始化，再执行子类的初始化。
### 3.3 抽象类
> 在Java中，用```abstract```修饰的类为抽象类，用```abstract```修饰的方法为抽象方法。
> - java中的抽象方法相当于C++中的纯虚函数。

**理解抽象类的要点：**
- 抽象类中的抽象方法可以有，也可以没有，也可以包含非抽象方法（已实现的方法）。反过来思考，类中只要有一个方法用```abstract```修饰，则该类就必须要用```abstract```来修饰。当然，如果一个抽象方法都没有，类也可以用```abstract```来修饰。
- 抽象类不能创建对象，只能由非抽象子类来创建对象。抽象类的声明能够引用非抽象子类的对象。
- 抽象类和具体类是一般和特殊的关系，是一种继承和被继承的关系。抽象类封装了类中不变的因素。
- 抽象类的非抽象子类必须实现抽象类中所有抽象方法，抽象类的抽象子类，不得声明和父类同名的抽象方法，即不能重载抽象方法。
- 在抽象类中，非抽象方法可以调用抽象方法（虽然没有实现），具体的实现交给非抽象子类，提高程序设计的完全性。
- ```abstract```和```final```是一对矛盾修饰符，因而不能修饰同一个类；同时```abstract```也不能与```private```、```static```和```native```修饰同一个方法。
#### 3.3.1 抽象类的设计用途
> 抽象类形成的思维过程一般为：客观事物-->对象-->类-->抽象类。

**1) 抽象类在继承方面的应用**

- 可以更加细致的设计一个系统，是系统的结构更清晰的展现出来。

**2) 抽象类在引用具体子类对象方面的应用——向上转型**

- 抽象类的声明可以引用子类的对象。

**3) 抽象类设计注意事项**

- 设计抽象类的抽象方法应该经过严谨的思考，满足很多的设计原则。
- 抽象类中所封装的属性和方法，应该尽可能简单，提现研究对象的本质。

### 3.4 接口
> 接口的两种含义：
>- 类中设计的成员方法
>- ```interface```关键词定义的数据类型，地位与```class```一样。

#### 3.4.1 接口的定义
```
[public] interface 接口名[extends 父接口名列表]
{
    //静态常量数据成员声明
    [public] [static] [final] 域类型 域名 = 常量值
    //抽象方法声明
    [public] [abstrct] 返回值 方法名(参数列表)[throw 异常列表]
}
```
**注意点：（默认是指不用任何修饰符修饰）**
- ```interface```前面要么用```public```修饰，要么为默认。
- 接口中定义的数据成员（属性）全是```final static```，即静态常量。默认效果一样。
- 接口所有方法都是抽象方法，即为```public abstract```修饰。默认效果一样。
- 接口可以继承其他接口，用```extends```关键词。
- 接口和子接口不能有自己的实例对象（与抽象类和抽象子类一致），但是，同时也可以用声明来引用实现类的对象，调用实现类中实现的方法。**（向上转型）**

> java中的接口机制，使得系统功能的实现和使用以弱耦合的方式连接起来。
#### 3.4.2 接口的实现与使用
**注意点：**
- 一个类可以通过```implements```关键来实现一个或者多个接口。
- 接口实现类可以继承接口中定义的常量，通过```类名.常量、引用名.常量、接口名.常量```来使用常量。
- 如果接口的实现类是抽象类，该抽象类可以实现接口中的方法，也可以不实现。但是，若果实现类不是抽象类，则必须实现接口中所有的方法。
- 接口实现类中实现接口方法时，必须加上```public```修饰符。因为接口中的默认访问控制范围与类中的默认访问控制范围时不一致的。

> 接口天生设计出来就提高程序的可扩展性。
>- Java事件处理中，监听器就是各种接口，实现类实现不同的监听接口中的方法，可以实现事物发生对象和事物处理对象的分离。
>
> **抽象类与接口的比较**
>- 相同点
> 
>  抽象类和接口都有抽象方法，都不能实例化。都有自己的声明，并且可以引用具体子类或实现类的对象。
>- 不同点
>
> 属性：抽象类可以有域变量，接口不能有域变量，只能有静态常量。
> 
> 成员方法：抽象类可以有具体方法，而且具体方法可以调用抽象方法。接口的成员方法全是抽象方法。
>
> 实现策略：抽象类必须有具体子类继承，实现其中的抽象方法。接口也必须有实现类实现其中的成员方法。
>
> 扩展性：抽象类的扩展性较弱，接口的扩展性较强。
>
> **接口相比与抽象类，既能保证系统的稳定性，也能保证一定的可扩展性**

### 3.5 引用
> 面向对象的特征是抽象、封装、继承和多态。

#### 3.5.1 引用要点
- 引用的形成：先声明，赋予对象后声明变为引用（引用是一种控制权的获得：通过赋值，使得一个“空指针”指向了一个对应类型的实例，之后不再是“空指针”）。
- 抽象类声明引用的特点：抽象类声明可以应用所有具体子类对象。可以说，所有父类声明可以引用具体子类的对象。
- 引用替换原则：父类声明可以引用不同的子类对象，并且可以在运行时换成替换操作。具体子类声明不能引用平行具体子类（继承了同一个父类）的对象，也不能引用父类对象。
- A父类声明和具体B子类声明引用同一个B子类对象，两者的角度不同，能获取的属性和方法不一样。父类声明的引用转化成子类声明的引用需要强制转换（造型cast）,而子类声明的引用赋值给父类声明，不需要造型。
- 接口声明引用具体子类的对象，只能调用具体子类实现的接口方法。

#### 3.5.2 引用比较
**1) 使用```equals(Object)```方法比较**
- 该方法用于比较两个类声明的引用是否是同一个对象的引用。
- ```equals(Object)```方法具有**自反性**，即```x.equals(x) ≡ true```
- ```equals(Object)```方法具有**对称性**，即```x.equals(y) ≡ y.equals(x)```
- ```equals(Object)```方法具有**传递性**，即```x.equals(y) = true && y.equals(z) = true -> x.equals(z) = true```
-  ```equals(Object)```方法具有**一致性**，即```equals(Object)```方法中操作的数据没有被更改，```x.euqals(y)```的值在多次调用下任保持一致。
-  **```x.euqals(null) ≡ false```**
-  任何一个类覆盖了```equals()```方法，都必须，满足**自反性、对称性、传递性和一致性**。
-  

**2) 使用“==”进行比较**
- 可以比较两个对象引用是否相等
- 可以比较两个基本类型的数值是否相等

**3) 使用```instanceof```比较引用类型**
- 用来判断引用的对象的类型是否是某一个类型，例如：```a instanceof A```表示引用a是否为 类A的一个对象或者子类对象的引用。
- ```instanceof```比较结果有三种：```true```、```false```（a为A的父类的对象的引用）、编译不通过（a与A没有任何关系）

#### 3.5.3 引用案例
> 接口声明引用具体子类的对象，父类声明引用具体子类的对象，他们的引用的操作范围，只限制在自己定义的内容，不能操作具体子类中另外定义的属性和方法。

### 3.6 类的其他内容
#### 3.6.1 类的完整定义形式
```C
[修饰符] class 类名 [extends 父类] [implements 接口名1,接口名2,...]
{
    类域变量;
    类方法;
}
//其中修饰符为：public，默认（即省略修饰符），abstract或final，但不能被被private、protected所修饰。除非是内部类。
```
#### 3.6.2 内部类
> 内部类就是在类的内部又定义一个类。

**内部类相关要点：**
- 内部类可以直接访问外部类中的所有属性，包括修饰符为```private```的属性和方法。外部类无法直接访问内部类中的成员。
- 内部类对象的产生方法：如果内部类的修饰符为```public```可以用```Outer.Inner inner = outer.new Inner()```的形式类创建内部类对象。如果修饰符为```private```，通过外部类定义类似与单例模式的```getInstance()```成员方法，来创建并获取内部类对象。
- static修饰内部类时，相当于外部类的一个静态属性，可以用```Outer.Inner inner  = new Outer.Inner()```的形式类创建内部类对象。
- 内部类可以为抽象类
- 内部类定义在方法体类，只能访问方法体内的常量，而不能访问方法体内的局部变量，且方法体内的内部类前不应该有修饰符。
- 非静态内部类如果不是定义在静态方法中，就不能直接在类的静态方法中调用。要采用```Outer.Inner inner = outer.new Inner()```的形式类创建内部类对象。或者内部类改成静态内部类，或者在静态方法中先定义，再使用。
#### 3.6.3 匿名内部类
> 一种没有名称的类的定义方式。
**匿名内部类使用规则**
- 匿名内部类不能有构造方法，但是如果这个类继承了一个带有构造函数的父类，在创建它的对象的时候必须传入响应的参数。
- 匿名内部类不能定义任何静态的成员和方法。
- 匿名内部类不能被```public、protected、private、static```修饰。
- 只能创建匿名内部类的一个实例。

**匿名内部类的使用条件**
- 只用到类的一个实例的时候。
- 类在定义后马上用到。
- 类非常小，代码量小，行数为个位数。

#### 3.6.4 匿名对象
> 匿名对象就是对象创建时没有显式地为其指定引用的对象。

**使用情形：**
- 如果对一个对象只需要进行一次方法调用。
- 将匿名对象作为参数传递给一个方法。（java中为一个控件添加监听器）
#### 3.6.5 特殊的类——类对象
```
public final class Class<T> extends Object implements Serializable, GenericDeclaration, Type, AnnotatedElement
```
任何对象都以类为模板产生，反过来也可以通过对象而得到类的描述信息。以下是Class类的常用方法：
>- static Class<?>  forName(String className)//通过完整包路径来获取一个类的的Class对象
>- static Class<?>  forName(String name, boolean initialize, ClassLoader loader)//
>- Field	getField(String name)//获取该类中命名为name字符串一样的域变量
>- Field[]	getFields()//获取该类的所有域变量
>- Method	getMethod(String name, Class<?>... parameterTypes)//获取该类中命名为name字符串一样且参数类型为parameterTypes的成员方法
>- Method[]	getMethods()//获取该类的所有成员方法
>- Type[]	getGenericInterfaces()//获取该类的所有实现的接口
>- Type getGenericSuperclass()//获取该类的父类
>- Class<?>[]	getInterfaces()
>- Package	getPackage()//获取该类的包名
>- Package	getName()//获取该类的完成包路径

- Java.lang.Class是一个比较特殊的类，它用于封装被装入到JVM中的类（包括类和接口）的信息。当一个类或接口被装入的JVM时便会产生一个与之关联的java.lang.Class对象，可以通过这个Class对象对被装入类的详细信息进行访问。（Java中Class对象和类的实例对象是两个不同的概念，不能混淆！）。 
- Class 类没有公共构造方法。
- 一般某个类的Class对象被载入内存（只有一份），它就用来创建这个类的所有对象。

**获取Class对象的方法：**
- 通过根类Object类的getClass方法来获取
> java.lang.Object中定义有getClass方法：public final Class getClass()
所有Java对象都具备这个方法，该方法用于返回调用该方法的对象的所属类关联的Class对象
```
Date date1 = new Date();
Date date2 = new Date();
Class c1 = date1.getClass();
Class c2 = date2.getClass();
System.out.println(c1.getName()); // java.util.Date
System.out.println(c1 == c2); // true

```
- 使用.class的方式
> 使用类名加“.class”的方式即会返回与该类对应的Class对象。这个方法可以直接获得与指定类关联的Class对象，而并不需要有该类的对象存在。
```
Class clazz = String.class;
System.out.println(clazz.getName()); // java.lang.String
```
- 使用Class.forName方法
> Class有一个著名的static方法forName：public static Class forName(String className) throws ClassNotFoundException
该方法可以根据字符串参数所指定的类名获取与该类关联的Class对象。如果该类还没有被装入，该方法会将该类装入JVM。
```
package org.whatisjava.reflect;
public class Foo {
	public Foo() {
		System.out.println("Foo()");
	}
	static {
		System.out.println("Foo is initialized");
	}
	public static void main(String args[]){
	    Class clazz = Class.forName("org.whatisjava.reflect.Foo");
	}
}
//运行结果
Foo is initialized
由结果可知，一个类的类对象加载入JVM时，类中的静态成员，方法，代码块会被执行。
```
> Class.forName("org.whatisjava.reflect.Foo")首先会将reflection.Foo类装入JVM，并返回与之关联的Class对象。JVM装入Foo类后对其进行初始化，调用了其static块中的代码。需要注意的是：**forName方法的参数是类的完整限定名（即包含包名）。**

### 3.7 小结
- 本部分介绍了```this```、```super```、构造方法多态、抽象类、接口、引用、内部类、匿名类、匿名对象等概念。
- 重点是**引用**，对java封装、继承、多态，抽象类、接口等概念的考察，考察的角度是引用。