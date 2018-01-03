# Java面试资源
分享编程资源，一起用好资源，用好的资源 **QQ(50872495)**

> 这里汇总整理了网络上的Java面试题，持续更新
> * 百度"Java面试题"前200页

## 基本概念
* 操作系统中 heap 和 stack 的区别
答：java 的内存分为两类，一类是栈内存，一类是堆内存。栈内存是指程序进入一个方法时，会为这个方法单独分配一块私属存储空间，用于存储这个方法内部的局部变量，当这个方法结束时，分配给这个方法的栈会释放，这个栈中的变量也将随之释放。
堆是与栈作用不同的内存，一般用于存放不放在当前方法栈中的那些数据，例如，使用 new，创建的对象都放在堆里，所以，它不会随方法的结束而消失。 方法中的局部变量使用 final修饰后，放在堆中，而不是栈中。
 区别：
1.heap是堆，stack是栈。
2.stack的空间由操作系统自动分配和释放，heap的空间是手动申请和释放的，heap常用new关键字来分配。
3.stack空间有限，heap的空间是很大的自由区。
在Java中，若只是声明一个对象，则先在栈内存中为其分配地址空间，若再new一下，实例化它，则在堆内存中为其分配地址。
4.举例：
数据类型 变量名；这样定义的东西在栈区。如：Object a =null; 只在栈内存中分配空间，new 数据类型();或者malloc(长度);    这样定义的东西就在堆区
如：Object b =new Object(); 则在堆内存中分配空间
 
* 什么是基于注解的切面实现
答：spring中可以在方法前添加注解，使得在执行方法前后执行你所编写的代码，这用切面来形容很形象，Spring两大核心就是AOP和DI。
* 什么是 对象/关系 映射集成模块
答：spring通过提供ORM模块在JDBC基础上支持对象关系映射工具，这样的支持使得spring可以集成主流的ORM框架，包括Hibernate mybatis等。
* 什么是 Java 的反射机制
答：Java反射机制是指在运行态中，对于任意一个类，都能获取他的所有属性和方法，对于任意一个对象，都能调用他的任意一个方法和属性，这种动态获取的信息以及动态调用对象的方法的功能成为Java的反射机制。常见应用RPC，代理模式。
* 什么是 ACID
答：ACID，是指在可靠数据库管理系统（DBMS）中，事务(transaction)所应该具有的四个特性：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Durability）.这是可靠数据库所应具备的几个特性.
* BS与CS的联系与区别
答：bs是指浏览器服务器模式，cs是指客户端服务器模式，区别是cs一般需要安装客户端来和服务器通信，而bs直接使用浏览器即刻，联系是两者可以实现同样的功能，譬如现在的微信网页版 客户端 手机版，都可以由同样的服务端支撑。
* Cookie 和 Session的区别
答：1.由于HTTP协议是无状态的协议，所以服务端需要记录用户的状态时，就需要用某种机制来识具体的用户，这个机制就是Session.典型的场景比如购物车，当你点击下单按钮时，由于HTTP协议无状态，所以并不知道是哪个用户操作的，所以服务端要为特定的用户创建了特定的Session，用用于标识这个用户，并且跟踪用户，这样才知道购物车里面有几本书。这个Session是保存在服务端的，有一个唯一标识。在服务端保存Session的方法很多，内存、数据库、文件都有。集群的时候也要考虑Session的转移，在大型的网站，一般会有专门的Session服务器集群，用来保存用户会话，这个时候 Session 信息都是放在内存的，使用一些缓存服务比如Memcached之类的来放 Session。  2. 思考一下服务端如何识别特定的客户？这个时候Cookie就登场了。每次HTTP请求的时候，客户端都会发送相应的Cookie信息到服务端。实际上大多数的应用都是用 Cookie 来实现Session跟踪的，第一次创建Session的时候，服务端会在HTTP协议中告诉客户端，需要在 Cookie 里面记录一个Session ID，以后每次请求把这个会话ID发送到服务器，我就知道你是谁了。有人问，如果客户端的浏览器禁用了 Cookie 怎么办？一般这种情况下，会使用一种叫做URL重写的技术来进行会话跟踪，即每次HTTP交互，URL后面都会被附加上一个诸如 sid=xxxxx 这样的参数，服务端据此来识别用户。3. Cookie其实还可以用在一些方便用户的场景下，设想你某次登陆过一个网站，下次登录的时候不想再次输入账号了，怎么办？这个信息可以写到Cookie里面，访问网站的时候，网站页面的脚本可以读取这个信息，就自动帮你把用户名给填了，能够方便一下用户。这也是Cookie名称的由来，给用户的一点甜头。所以，总结一下：Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。
* fail-fast 与 fail-safe 机制有什么区别
答：failfast快速失败，只发起一次调用，失败立即报错，例如java集合快速失败，当多个线程对同一个集合的内容进行操作时，就会产生failfast事件；failover失效转移，当组件异常时，功能转移到备份组件，例如：主备模式；failsafe失效安全，即使在故障的情况下也不会造成伤害或者尽量减少伤害，例如红绿灯检测模块，当检测到故障时，变为闪烁错误，而不是全绿；failback，是指failover之后的自动恢复。
* get 和 post请求的区别
答：httpget是取内容，post是提交内容。
* Interface 与 abstract 类的区别
答：接口只是一个方法的集合，如何implements一个接口就必须实现他的所有方法，如果要实现多重继承就一定得使用接口；抽象类不能被实例化，里边可以有方法的默认实现，如果基础模块在改进，那么就使用抽象类，不用修改继承他的类。
* IOC的优点是什么
答：控制反转是spring中最重要的思想。https://www.zhihu.com/question/23277575。第一个好处就是不用写那么多new了，第二个好处就是创建实例时不需要了解底层类的细节了。
* IO 和 NIO的区别，NIO优点
* Java 8 / Java 7 为我们提供了什么新功能
* 什么是竞态条件？ 举个例子说明。
* JRE、JDK、JVM 及 JIT 之间有什么不同
* MVC的各个部分都有那些技术来实现?如何实现?
* RPC 通信和 RMI 区别 
答：RPC是远程过程调用，RMI是RPC的一种Java实现，只能局限与java语言，功能简单。
* 什么是 Web Service（Web服务）
* JSWDL开发包的介绍。JAXP、JAXM的解释。SOAP、UDDI,WSDL解释。 
* WEB容器主要有哪些功能? 并请列出一些常见的WEB容器名字。
* 一个".java"源文件中是否可以包含多个类（不是内部类）？有什么限制
* 简单说说你了解的类加载器。是否实现过类加载器
* 解释一下什么叫AOP（面向切面编程）
* 请简述 Servlet 的生命周期及其相关的方法
* 请简述一下 Ajax 的原理及实现步骤
* 简单描述Struts的主要功能
* 什么是 N 层架构
* 什么是CORBA？用途是什么
* 什么是Java虚拟机？为什么Java被称作是“平台无关的编程语言”
答：java文件会被编译成为.class文件，由java虚拟机加载执行，常见的jvm是hotspot，底层由c++实现，在虚拟机层将平台差异屏蔽，所以上层的java语言可以做到与平台无关。
* 什么是正则表达式？用途是什么？哪个包使用正则表达式来实现模式匹配
* 什么是懒加载（Lazy Loading）
答：lazyloading 延迟加载是一种策略，在hibernate spring中均有实现，大体意思是，譬如一个集合中包含很多子项，调取集合时并不会将子项都加载出来，而是会等具体调用子项时才加载，为了提高性能。
* 什么是尾递归，为什么需要尾递归
* 什么是控制反转（Inversion of Control）与依赖注入（Dependency Injection）
答：https://www.zhihu.com/question/23277575

## 关键字
* finalize
    * 什么是finalize()方法
        * finalize()方法什么时候被调用
        * 析构函数(finalization)的目的是什么
        * final 和 finalize 的区别
        * final
    * final关键字有哪些用法
        * final 与 static 关键字可以用于哪里？它们的作用是什么
        * final, finally, finalize的区别
        * final、finalize 和 finally 的不同之处？ 
    * 能否在运行时向 static final 类型的赋值
        * 使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变
        * 一个类被声明为final类型，表示了什么意思
        * throws, throw, try, catch, finally分别代表什么意义
* Java 有几种修饰符？分别用来修饰什么
* volatile
    * volatile 修饰符的有过什么实践
    * volatile 变量是什么？volatile 变量和 atomic 变量有什么不同
    * volatile 类型变量提供什么保证？能使得一个非原子操作变成原子操作吗
    * 能创建 volatile 数组吗？ 
* transient变量有什么特点
* super什么时候使用
* public static void 写成 static public void会怎样
* 说明一下public static void main(String args[])这段声明里每个关键字的作用
* 请说出作用域public, private, protected, 以及不写时的区别
* sizeof 是Java 的关键字吗
* static
     * static class 与 non static class的区别
     * static 关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法
     * 静态类型有什么特点
     * main() 方法为什么必须是静态的？能不能声明 main() 方法为非静态
     * 是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用
     * 静态变量在什么时候加载？编译期还是运行期？静态代码块加载的时机呢
     * 成员方法是否可以访问静态变量？为什么静态方法不能访问成员变量
* switch
     * switch 语句中的表达式可以是什么类型数据
     * switch 是否能作用在byte 上，是否能作用在long 上，是否能作用在String上
* while 循环和 do 循环有什么不同

## 操作符
* &操作符和&&操作符有什么区别?
* a = a + b 与 a += b 的区别？ 
* 逻辑操作符 (&,|,^)与条件操作符(&&,||)的区别
* 3\*0.1 == 0.3 将会返回什么？true 还是 false？ 
* float f=3.4; 是否正确？
* short s1 = 1; s1 = s1 + 1;有什么错?

## 数据结构
* 基础类型(Primitives)
    * 基础类型(Primitives)与封装类型(Wrappers)的区别在哪里
    * 简述九种基本数据类型的大小，以及他们的封装类
    * int 和 Integer 哪个会占用更多的内存？ int 和 Integer 有什么区别？parseInt()函数在什么时候使用到
    * float和double的默认值是多少
    * 如何去小数四舍五入保留小数点后两位
    * char 型变量中能不能存贮一个中文汉字，为什么
* 类型转换
    * 怎样将 bytes 转换为 long 类型
    * 怎么将 byte 转换为 String
    * 如何将数值型字符转换为数字
    * 我们能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象
    * 能在不进行强制转换的情况下将一个 double 值赋值给 long 类型的变量吗
    * 类型向下转换是什么
* 数组
   * 如何权衡是使用无序的数组还是有序的数组
   * 怎么判断数组是 null 还是为空
   * 怎么打印数组？ 怎样打印数组中的重复元素
   * Array 和 ArrayList有什么区别？什么时候应该使用Array而不是ArrayList
   * 数组和链表数据结构描述，各自的时间复杂度
   * 数组有没有length()这个方法? String有没有length()这个方法
* 队列
   * 队列和栈是什么，列出它们的区别
   * BlockingQueue是什么
   * 简述 ConcurrentLinkedQueue LinkedBlockingQueue 的用处和不同之处。
* ArrayList、Vector、LinkedList的存储性能和特性
* String
* StringBuffer
    * ByteBuffer 与 StringBuffer有什么区别
* HashMap
    * HashMap的工作原理是什么
    
    答： 数据存储的主要类型有数组和链表，数组查询时间快，但是占用空间大，链表占用空间小，但是查询慢，所以出现了这种的办法，散列。hashmap是一种存储key-value的数据结构，采用数组的方式，每个数组元素都是一个链表，在数组合链表之间折中，实现数据的高效查询。https://www.cnblogs.com/dassmeta/p/5338955.html
    

	* 内部的数据结构是什么
	
	答： jdk1.8之前hashmap是纯粹的数组+链表，定义了一个内部类，存储key val 和next，在1.8之后加入了红黑树。关于红黑树 http://blog.csdn.net/yang_yulei/article/details/26066409
    * HashMap 的 table的容量如何确定？loadFactor 是什么？ 该容量如何变化？这种变化会带来什么问题？
    
    答：hashmap table 默认初始容量是16， loadfactor默认是.75。容量是指哈希表中桶的数量，loadfactor是哈希表在其容量自动增加之前可以达到多满的一种尺度，是衡量散列表空间的使用程度。随着hashmap中元素越来越多，发生碰撞的概率就越来越大，所产生的链表长度就会越来越长，这样会影响hashmap的查询速度，为了保证效率，必须在某个临界点进行扩容处理。该临界点在当hashmap中元素的数量 == table数组长度*loadfactor


    * HashMap 实现的数据结构是什么？如何实现

    答：数组+链表 红黑树

    * HashMap 和 HashTable、ConcurrentHashMap 的区别
    
	答： hashtable和hashmap采用相同的存储机制，两者的实现基本一致，不同的是：hashmap是非线程安全的，hashtable是线程安全的，其内部方法都是synchronized；hashtable不允许有null值的存在，再hashtable中调用put方法时，如果key为null，直接抛出nullpointerexception。
	concurrenthashmap是线程安全的hashmap的实现，与hashtable的不同是hashtable使用synchronized关键字加锁的原理，其实是对象加锁，不论是在方法前加还是语句块加，锁住的都是对象整体，但concurrenthashmap的同步机制和这个不同，它不是synchronized关键字，而是基于lock操作，这样的目的是保证同步的时候，锁住的不是整个对象，事实上,concurrenthashmap可以满足concurrentlevel个线程并发无阻塞的操作集合对象。                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    * HashMap的遍历方式及效率
    答： 第一种方式是遍历key，根据key获取映射的vlaue，需要调用get()方法十万次，肯定是效率不高的。建议在数据量较大时不用此方式遍历hashMap。第二种方式是获取集合中的values，遍历value。但是在遍历value的时候，获取不到key。建议在只需要获取集合中的value时使用此方式。第三种方式是获取Entry<K,V>类型的Set集合，遍历这个集合，获取每一个Entry<K,V>，通过getKey()和getValue来获取key和value。Entry<K,V>是HashMap集合中的键值对。这样就就相当于遍历了一遍HashMap中的键值对 。

    * HashMap、LinkedMap、TreeMap的区别
    答：hashmap是最常用的map，根据键可以直接获取它的值，具有很快的访问速度，遍历时，取得数据的顺序是完全随机的。
	linkedhashmap保存了记录的插入顺序，在用iterator遍历linkedhashmap时，先得到的记录肯定是先插入的。
	treemap实现sortmap借口，能够把保存的记录按键来进行排序，默认是升序排序，也可以指定排序器。
	应用场景：1.一般情况下，用的最多的是hashmap，在map中插入删除定位元素，hashmap是最好的选择；2.treemap取出来是排序后的键值对。3.linkedhashmap是hashmap的一个子类，如果要输出的顺序和输入的顺序相同，可以用linkedhashmap来实现。
    * 如何决定选用HashMap还是TreeMap
    答：同上。
    * 如果HashMap的大小超过了负载因子(load factor)定义的容量，怎么办 
    答：扩容。hashmap中的resize函数
    * HashMap 是线程安全的吗？并发下使用的 Map 是什么，它们内部原理分别是什么，比如存储方式、 hashcode、扩容、 默认容量等
    答： hashmap非线程安全，并发先使用hashtable和concurrenthashmap。默认容量都一样，都是16，只是加锁。
* HashSet
    * HashSet和TreeSet有什么区别 
    答：set集合中的元素是无序的，不可重复的，这个接口下有两个常用集合的实现，hashset和treeset。Hashset底层用的是哈希表，它吧对象根据其哈希值存放到对应的区域里，由于这种特性，两个在不同区域的对象会人为是不同的。所以如果对象要存放到hash集合里，则需要重写hashcode方法，让相等的对象的hashcode也相等。Treeset采用的数据结构是红黑树，可以按指定规则对其中的元素进行排序。treeset判断元素相同，除了用equals方法检查外，还要检查compareTo方法是否返回0，所以如果要将对象存放到treeset中，需要重写compareTo时，吧相同对象的比较值定为0，防止相同的元素被重复添加进集合。
    * HashSet 内部是如何工作的
    答：内部采用hashmap存储，add方法调用了map的put()方法，map的put方法会检查这个键是否已存在，若是则返回该键之前的值，若不是则返回null，源码如下：
	public boolean add(E e ) {  
        return map.put(e, PRESENT)== null;  
    }  
    * WeakHashMap 是怎么工作的？
    答： weakhashmap是弱引用，在hashmap中存储键值对时，当内存不足时，会抛出异常，而weakhashmap则不会，它会清理弱引用。适用于类似缓存的应用场景。http://blog.csdn.net/u013256816/article/details/50916504
* Set
    * Set 里的元素是不能重复的，那么用什么方法来区分重复与否呢？是用 == 还是 equals()？ 它们有何区别?
    * TreeMap：TreeMap 是采用什么树实现的？TreeMap、HashMap、LindedHashMap的区别。TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？
    * TreeSet：一个已经构建好的 TreeSet，怎么完成倒排序。
    * EnumSet 是什么
    答：enumset是一个专为枚举设计的集合类，enumset中所有元素都必须是指定枚举类型的枚举值，该枚举类型在创建enumset时显式或隐式指定。
* Hash算法
    * Hashcode 的作用
    答： hashcode主要用于查找的快捷性，用来在散列存储结构中确定对象的存储地址。
    * 简述一致性 Hash 算法
    答： http://www.zsythink.net/archives/1182 缓存服务器时，当添加或者删除服务器时，会造成所有缓存失效，使用一致性hash环，即跟2^32求余，会使得增加或者删除服务器对缓存的影响非常小。
    * 有没有可能 两个不相等的对象有相同的 hashcode？当两个对象 hashcode 相同怎么办？如何获取值对象 
    答：可能，hashcode一样不定代表两个对象是同一个对象。
    * 为什么在重写 equals 方法的时候需要重写 hashCode 方法？equals与 hashCode 的异同点在哪里
    答： equals是判断两个对象是否相同的标准，如果重写了equals方法而不重写hashcode会造成equals返回true，但是hashcode却不相等的情况，会造成一些数据结构的失效。
	* a.hashCode() 有什么用？与 a.equals(b) 有什么关系
	
	答： 1.Object类的public boolean equals(Object obj)方法是通过 return this == obj;这种方式比较两个对象是否相同。这里比较的是引用。
	2.Object类的public int hashCode()方法，是通过该实例地址转换为int值。所以不同的Object实例在同一运行期hashCode一定不相同。
	
	以上两点是针对Object类本身说的，但是不同的子类会重写这两个方法，满足他们各自的比较特性，比如众所周知的String中equals()方法就是比较内容，而不是比较this == obj。相同的，String对象的hashCode也不是内存地址的反应，而是通过对String的value计算得到一个int值来做hashCode()结果。
	
	所以每个类都可以分别将equals和hashCode两个方法重写。但是一般都是一起重写，使其基于同样的比较方法，就像上面String那样。这是出于一种协定，因为很多情况下，从提高效率角度出发，比较两个对象时候，hashCode会优先于equals方法，这个可以看JDK源代码中HashMap的put(K,V)方法。源码中，首先比较K的hashCode然后再比较equals。说明JDK协定：如果hashCode不相同，那么两个对象一定不相同；如果hashCode相同，那么两个对象还得通过equals来比较（另外hibernate里面好像也有类似的机制来比较Entity Bean，但是说实话我不太了解详细情况，这里不敢多讲哈）。我想，这恐怕就是指导大家每次同时重写两个方法的原则吧。

    * hashCode() 和 equals() 方法的重要性体现在什么地方
    * Object：Object有哪些公用方法？Object类hashcode,equals 设计原则？ sun为什么这么设计？Object类的概述
    * 如何在父类中为子类自动完成所有的 hashcode 和 equals 实现？这么做有何优劣。
    * 可以在 hashcode() 中使用随机数字吗？
* LinkedHashMap
    * LinkedHashMap 和 PriorityQueue 的区别是什么
* List
    * List, Set, Map三个接口，存取元素时各有什么特点
    * List, Set, Map 是否继承自 Collection 接口
    * 遍历一个 List 有哪些不同的方式
    * LinkedList
        * LinkedList 是单向链表还是双向链表
        * LinkedList 与 ArrayList 有什么区别
        * 描述下 Java 中集合（Collections），接口（Interfaces），实现（Implementations）的概念。LinkedList 与 ArrayList 的区别是什么？
        * 插入数据时，ArrayList, LinkedList, Vector谁速度较快？
    * ArrayList
        * ArrayList 和 HashMap 的默认大小是多数
        * ArrayList 和 LinkedList 的区别，什么时候用 ArrayList？
        * ArrayList 和 Set 的区别？
        * ArrayList, LinkedList, Vector的区别
        * ArrayList是如何实现的，ArrayList 和 LinkedList 的区别
        * ArrayList如何实现扩容
        * Array 和 ArrayList 有何区别？什么时候更适合用Array
        * 说出ArraList,Vector, LinkedList的存储性能和特性
* Map
    * Map, Set, List, Queue, Stack
    * Map 接口提供了哪些不同的集合视图
    * 为什么 Map 接口不继承 Collection 接口
* Collections
    * 介绍Java中的Collection FrameWork。集合类框架的基本接口有哪些
    * Collections类是什么？Collection 和 Collections的区别？Collection、Map的实现
    * 集合类框架的最佳实践有哪些
    * 为什么 Collection 不从 Cloneable 和 Serializable 接口继承
    * 说出几点 Java 中使用 Collections 的最佳实践？
    * Collections 中 遗留类 (HashTable、Vector) 和 现有类的区别
*  什么是 B+树，B-树，列出实际的使用场景。

## 接口
* Comparator 与 Comparable 接口是干什么的？列出它们的区别

## 对象
* 拷贝(clone)
    * 如何实现对象克隆
    * 深拷贝和浅拷贝区别
    * 深拷贝和浅拷贝如何实现激活机制
    * 写clone()方法时，通常都有一行代码，是什么
* 比较
    * 在比较对象时，"==" 运算符和 equals 运算有何区别
    * 如果要重写一个对象的equals方法，还要考虑什么
    * 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对
* 构造器
    * 构造器链是什么
    * 创建对象时构造器的调用顺序
* 不可变对象
    * 什么是不可变象（immutable object）
    * 为什么 Java 中的 String 是不可变的（Immutable）
    * 如何构建不可变的类结构？关键点在哪里
    * 能创建一个包含可变对象的不可变对象吗
* 如何对一组对象进行排序

## 方法
* 构造器（constructor）是否可被重写（override）
* 方法可以同时即是 static 又是 synchronized 的吗
* abstract 的 method是否可同时是 static，是否可同时是 native，是否可同时是synchronized
* Java支持哪种参数传递类型
* 一个对象被当作参数传递到一个方法，是值传递还是引用传递
* 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递
* 我们能否重载main()方法
* 如果main方法被声明为private会怎样

## GC
* 概念
    * GC是什么？为什么要有GC
    * 什么时候会导致垃圾回收
    * GC是怎么样运行的
    * 新老以及永久区是什么
    * GC 有几种方式？怎么配置
    * 什么时候一个对象会被GC？ 如何判断一个对象是否存活
    * System.gc()  Runtime.gc()会做什么事情？  能保证 GC 执行吗
    * 垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？
    * Minor GC 、Major GC、Young GC 与 Full GC分别在什么时候发生
    * 垃圾回收算法的实现原理
    * 如果对象的引用被置为null，垃圾收集器是否会立即释放对象占用的内存？
    * 垃圾回收的最佳做法是什么
* GC收集器有哪些
     * 垃圾回收器的基本原理是什么？
     * 串行(serial)收集器和吞吐量(throughput)收集器的区别是什么
    * Serial 与 Parallel GC之间的不同之处
    * CMS 收集器 与 G1 收集器的特点与区别
    * CMS垃圾回收器的工作过程
    * JVM 中一次完整的 GC 流程是怎样的？ 对象如何晋升到老年代
    * 吞吐量优先和响应优先的垃圾收集器选择
* GC策略
     * 举个实际的场景，选择一个GC策略
     * JVM的永久代中会发生垃圾回收吗
* 收集方法
    * 标记清除、标记整理、复制算法的原理与特点？分别用在什么地方
    * 如果让你优化收集方法，有什么思路

## JVM
* 参数
    * 说说你知道的几种主要的jvm 参数
    * -XX:+UseCompressedOops 有什么作用
* 类加载器(ClassLoader)
    * Java 类加载器都有哪些
    * JVM如何加载字节码文件
* 内存管理 
    * JVM内存分哪几个区，每个区的作用是什么
    * 一个对象从创建到销毁都是怎么在这些部分里存活和转移的
    *  解释内存中的栈(stack)、堆(heap)和方法区(method area)的用法
    * JVM中哪个参数是用来控制线程的栈堆栈小
    *  简述内存分配与回收策略
    *  简述重排序，内存屏障，happen-before，主内存，工作内存
    * Java中存在内存泄漏问题吗？请举例说明
    * 简述 Java 中软引用（SoftReferenc）、弱引用（WeakReference）和虚引用
    * 内存映射
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 区是什么
* jstack，jstat，jmap，jconsole怎么用
* 32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？32 位和 64 位的 JVM，int 类型变量的长度是多数？
* 怎样通过 Java 程序来判断 JVM 是 32 位 还是 64 位 
* JVM自身会维护缓存吗？是不是在堆中进行对象分配，操作系统的堆还是JVM自己管理堆
* 什么情况下会发生栈内存溢出
* 双亲委派模型是什么

## 多线程
* 基本概念
    * 什么是线程
    * 多线程的优点
    * 多线程的几种实现方式
        * 用 Runnable 还是 Thread
    * 什么是线程安全
        * Vector, SimpleDateFormat 是线程安全类吗
        * 什么 Java 原型不是线程安全的
        * 哪些集合类是线程安全的
    * 多线程中的忙循环是什么
    * 如何创建一个线程
    * 编写多线程程序有几种实现方式
    * 什么是线程局部变量
    * 线程和进程有什么区别？进程间如何通讯，线程间如何通讯
    * 什么是多线程环境下的伪共享（false sharing）
    * 同步和异步有何异同，在什么情况下分别使用他们？举例说明
* Current
    * ConcurrentHashMap 和 Hashtable的区别
    * ArrayBlockingQueue, CountDownLatch的用法
    * ConcurrentHashMap的并发度是什么
* CyclicBarrier 和 CountDownLatch有什么不同？各自的内部原理和用法是什么
* Semaphore的用法
* Thread
    * 启动一个线程是调用 run() 还是 start() 方法？start() 和 run() 方法有什么区别
    * 调用start()方法时会执行run()方法，为什么不能直接调用run()方法
    * sleep() 方法和对象的 wait() 方法都可以让线程暂停执行，它们有什么区别
    * yield方法有什么作用？sleep() 方法和 yield() 方法有什么区别
    * Java 中如何停止一个线程
    * stop() 和 suspend() 方法为何不推荐使用
    * 如何在两个线程间共享数据
    * 如何强制启动一个线程
    * 如何让正在运行的线程暂停一段时间
    * 什么是线程组，为什么在Java中不推荐使用
    * 你是如何调用  wait（方法的）？使用 if 块还是循环？为什么
* 生命周期
    * 有哪些不同的线程生命周期
    * 线程状态，BLOCKED 和 WAITING 有什么区别
    * 画一个线程的生命周期状态图
* ThreadLocal 用途是什么，原理是什么，用的时候要注意什么
* ThreadPool
   * 线程池是什么？为什么要使用它
   * 如何创建一个Java线程池
    * ThreadPool用法与优势
    * 提交任务时，线程池队列已满时会发会生什么
    * newCache 和 newFixed 有什么区别？简述原理。构造函数的各个参数的含义是什么，比如 coreSize, maxsize 等
    * 线程池的实现策略
    * 线程池的关闭方式有几种，各自的区别是什么
    * 线程池中submit() 和 execute()方法有什么区别？
* 线程调度
    * Java中用到的线程调度算法是什么
    * 什么是多线程中的上下文切换
    * 你对线程优先级的理解是什么
    * 什么是线程调度器 (Thread Scheduler) 和时间分片 (Time Slicing)
* 线程同步
    * 请说出你所知的线程同步的方法
    * synchronized 的原理是什么
    * synchronized 和 ReentrantLock 有什么不同
    * 什么场景下可以使用 volatile 替换 synchronized
    * 有T1，T2，T3三个线程，怎么确保它们按顺序执行？怎样保证T2在T1执行完后执行，T3在T2执行完后执行
    * 同步块内的线程抛出异常会发生什么
    * 当一个线程进入一个对象的 synchronized 方法A 之后，其它线程是否可进入此对象的 synchronized 方法B
    * 使用 synchronized 修饰静态方法和非静态方法有什么区别
    * 如何从给定集合那里创建一个 synchronized 的集合
* 锁
    * Java Concurrency API 中 的 Lock 接口是什么？对比同步它有什么优势
    * Lock 与 Synchronized 的区别？Lock 接口比 synchronized 块的优势是什么
    * ReadWriteLock是什么？
    * 锁机制有什么用
    * 什么是乐观锁（Optimistic Locking）？如何实现乐观锁？如何避免ABA问题
    * 解释以下名词：重排序，自旋锁，偏向锁，轻量级锁，可重入锁，公平锁，非公平锁，乐观锁，悲观锁
    * 什么时候应该使用可重入锁
    * 简述锁的等级方法锁、对象锁、类锁
    * Java中活锁和死锁有什么区别？
    * 什么是死锁(Deadlock)？导致线程死锁的原因？如何确保 N 个线程可以访问 N 个资源同时又不导致死锁
    * 死锁与活锁的区别，死锁与饥饿的区别
    * 怎么检测一个线程是否拥有锁
    * 如何实现分布式锁
    * 有哪些无锁数据结构，他们实现的原理是什么
    * 读写锁可以用于什么应用场景
* Executors类是什么？ Executor和Executors的区别
* 什么是Java线程转储(Thread Dump)，如何得到它
* 如何在Java中获取线程堆栈
* 说出 3 条在 Java 中使用线程的最佳实践
* 在线程中你怎么处理不可捕捉异常
* 实际项目中使用多线程举例。你在多线程环境中遇到的常见的问题是什么？你是怎么解决它的
* 请说出与线程同步以及线程调度相关的方法
* 程序中有3个 socket，需要多少个线程来处理
* 假如有一个第三方接口，有很多个线程去调用获取数据，现在规定每秒钟最多有 10 个线程同时调用它，如何做到
* 如何在 Windows 和 Linux 上查找哪个线程使用的 CPU 时间最长
* 如何确保 main() 方法所在的线程是 Java 程序最后结束的线程
* 非常多个线程（可能是不同机器），相互之间需要等待协调才能完成某种工作，问怎么设计这种协调方案
* 你需要实现一个高效的缓存，它允许多个用户读，但只允许一个用户写，以此来保持它的完整性，你会怎样去实现它

## 异常
* 基本概念
    * Error 和 Exception有什么区别 
        * UnsupportedOperationException是什么
        * NullPointerException 和 ArrayIndexOutOfBoundException 之间有什么相同之处
    * 什么是受检查的异常，什么是运行时异常
    * 运行时异常与一般异常有何异同
    * 简述一个你最常见到的runtime exception(运行时异常)
* finally
    * finally关键词在异常处理中如何使用
        * 如果执行finally代码块之前方法返回了结果，或者JVM退出了，finally块中的代码还会执行吗
        * try里有return，finally还执行么？那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后
        * 在什么情况下，finally语句不会执行
* throw 和 throws 有什么区别？
* OOM你遇到过哪些情况？你是怎么搞定的？
* SOF你遇到过哪些情况？
* 既然我们可以用RuntimeException来处理错误，那么你认为为什么Java中还存在检查型异常
* 当自己创建异常类的时候应该注意什么
* 导致空指针异常的原因
* 异常处理 handle or declare 原则应该如何理解
* 怎么利用 JUnit 来测试一个方法的异常
* catch块里别不写代码有什么问题
* 你曾经自定义实现过异常吗？怎么写的
* 什么是 异常链
* 在try块中可以抛出异常吗

## JDBC
* 通过 JDBC 连接数据库有哪几种方式
* 阐述 JDBC 操作数据库的基本步骤
* JDBC 中如何进行事务处理
* 什么是 JdbcTemplate
* 什么是 DAO 模块
* 使用 JDBC 操作数据库时，如何提升读取数据的性能？如何提升更新数据的性能
* 列出 5 个应该遵循的 JDBC 最佳实践

## IO
* File
    * File类型中定义了什么方法来创建一级目录
        * File类型中定义了什么方法来判断一个文件是否存在
* 流
    * 为了提高读写性能，可以采用什么流
    * Java中有几种类型的流
    * JDK 为每种类型的流提供了一些抽象类以供继承，分别是哪些类
    * 对文本文件操作用什么I/O流
    * 对各种基本数据类型和String类型的读写，采用什么流
    * 能指定字符编码的 I/O 流类型是什么
* 序列化
    * 什么是序列化？如何实现 Java 序列化及注意事项
    * Serializable 与 Externalizable 的区别
* Socket
    * socket 选项 TCP NO DELAY 是指什么
    * Socket 工作在 TCP/IP 协议栈是哪一层
    * TCP、UDP 区别及 Java 实现方式
* 说几点 IO 的最佳实践
* 直接缓冲区与非直接缓冲器有什么区别？
* 怎么读写 ByteBuffer？ByteBuffer 中的字节序是什么
* 当用System.in.read(buffer)从键盘输入一行n个字符后，存储在缓冲区buffer中的字节数是多少
* 如何使用扫描器类（Scanner Class）令牌化

## 面向对象编程（OOP）
* 解释下多态性（polymorphism），封装性（encapsulation），内聚（cohesion）以及耦合（coupling）
* 多态的实现原理
* 封装、继承和多态是什么
* 对象封装的原则是什么?
* 类
    * 获得一个类的类对象有哪些方式
    * 重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？
    * 说出几条 Java 中方法重载的最佳实践
* 抽象类
    * 抽象类和接口的区别
    * 抽象类中是否可以有静态的main方法
    * 抽象类是否可实现(implements)接口
    * 抽象类是否可继承具体类(concrete class)
* 匿名类（Anonymous Inner Class）
    * 匿名内部类是否可以继承其它类？是否可以实现接口
* 内部类
    * 内部类分为几种
    * 内部类可以引用它的包含类（外部类）的成员吗
    * 请说一下 Java 中为什么要引入内部类？还有匿名内部类
* 继承
    * 继承（Inheritance）与聚合（Aggregation）的区别在哪里
    * 继承和组合之间有什么不同
    * 为什么类只能单继承，接口可以多继承
    * 存在两个类，B 继承 A，C 继承 B，能将 B 转换为 C 么？如 C = (C) B
    * 如果类 a 继承类 b，实现接口c，而类 b 和接口 c 中定义了同名变量，请问会出现什么问题
* 接口
    * 接口是什么
    * 接口是否可继承接口
    * 为什么要使用接口而不是直接使用具体类？接口有什么优点

## 泛型
* 泛型的存在是用来解决什么问题
* 泛型的常用特点
* List<String>能否转为List<Object>

## 工具类
* 日历
    * Calendar Class的用途
    * 如何在Java中获取日历类的实例
    * 解释一些日历类中的重要方法
     * GregorianCalendar 类是什么
     * SimpleTimeZone 类是什么
     * Locale类是什么
     * 如何格式化日期对象
     * 如何添加小时(hour)到一个日期对象(Date Objects)
     * 如何将字符串 YYYYMMDD 转换为日期
* Math
    * Math.round()什么作用？Math.round(11.5) 等于多少？Math.round(-11.5)等于多少？
* XML
    * XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式？DOM 和 SAX 解析器有什么不同？
    * Java解析XML的方式
    * 用 jdom 解析 xml 文件时如何解决中文问题？如何解析
    * 你在项目中用到了 XML 技术的哪些方面？如何实现

## 动态代理
* 描述动态代理的几种实现方式，分别说出相应的优缺点

## 设计模式
* 什么是设计模式（Design Patterns）？你用过哪种设计模式？用在什么场合
* 你知道哪些商业级设计模式？
* 哪些设计模式可以增加系统的可扩展性
* 单例模式
    * 除了单例模式，你在生产环境中还用过什么设计模式？ 
    * 写 Singleton 单例模式
    * 单例模式的双检锁是什么
    * 如何创建线程安全的 Singleton
    * 什么是类的单例模式
    * 写出三种单例模式实现
* 适配器模式
    * 适配器模式是什么？什么时候使用
    * 适配器模式和代理模式之前有什么不同
    * 适配器模式和装饰器模式有什么区别
* 什么时候使用享元模式
* 什么时候使用组合模式
* 什么时候使用访问者模式
* 什么是模板方法模式
* 请给出1个符合开闭原则的设计模式的例子

## 开放问题
* 用一句话概括 Web 编程的特点
* Google是如何在一秒内把搜索结果返回给用户
* 哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入
* 树（二叉或其他）形成许多普通数据结构的基础。请描述一些这样的数据结构以及何时可以使用它们
* 某一项功能如何设计
* 线上系统突然变得异常缓慢，你如何查找问题
* 什么样的项目不适合用框架
* 新浪微博是如何实现把微博推给订阅者
* 简要介绍下从浏览器输入 URL 开始到获取到请求界面之后 Java Web 应用中发生了什么
* 请你谈谈SSH整合 
* 高并发下，如何做到安全的修改同一行数据
* 12306网站的订票系统如何实现，如何保证不会票不被超卖
* 网站性能优化如何优化的
* 聊了下曾经参与设计的服务器架构
* 请思考一个方案，实现分布式环境下的 countDownLatch
* 请思考一个方案，设计一个可以控制缓存总体大小的自动适应的本地缓存
* 在你的职业生涯中，算得上最困难的技术挑战是什么
* 如何写一篇设计文档，目录是什么
* 大写的O是什么？举几个例子
* 编程中自己都怎么考虑一些设计原则的，比如开闭原则，以及在工作中的应用
* 解释一下网络应用的模式及其特点
* 设计一个在线文档系统，文档可以被编辑，如何防止多人同时对同一份文档进行编辑更新
* 说出数据连接池的工作机制是什么
* 怎么获取一个文件中单词出现的最高频率
* 描述一下你最常用的编程风格
* 如果有机会重新设计你们的产品，你会怎么做
* 如何搭建一个高可用系统
* 如何启动时不需输入用户名与密码
* 如何在基于Java的Web项目中实现文件上传和下载
* 如何实现一个秒杀系统，保证只有几位用户能买到某件商品。
* 如何实现负载均衡，有哪些算法可以实现
* 如何设计一个购物车？想想淘宝的购物车如何实现的
* 如何设计一套高并发支付方案，架构如何设计
* 如何设计建立和保持 100w 的长连接
* 如何避免浏览器缓存。
* 如何防止缓存雪崩
* 如果AB两个系统互相依赖，如何解除依
* 如果有人恶意创建非法连接，怎么解决
* 如果有几十亿的白名单，每天白天需要高并发查询，晚上需要更新一次，如何设计这个功能
* 如果系统要使用超大整数（超过long长度范围），请你设计一个数据结构来存储这种超大型数字以及设计一种算法来实现超大整数加法运算）
* 如果要设计一个图形系统，请你设计基本的图形元件(Point,Line,Rectangle,Triangle)的简单实现
* 如果让你实现一个并发安全的链表，你会怎么做
* 应用服务器与WEB 服务器的区别？应用服务器怎么监控性能，各种方式的区别？你使用过的应用服务器优化技术有哪些
* 大型网站在架构上应当考虑哪些问题
* 有没有处理过线上问题？出现内存泄露，CPU利用率标高，应用无响应时如何处理的
* 最近看什么书，印象最深刻的是什么
* 描述下常用的重构技巧
* 你使用什么版本管理工具？分支（Branch）与标签（Tag）之间的区别在哪里
* 你有了解过存在哪些反模式（Anti-Patterns）吗
* 你用过的网站前端优化的技术有哪些
* 如何分析Thread dump
* 你如何理解AOP中的连接点（Joinpoint）、切点（Pointcut）、增强（Advice）、引介（Introduction）、织入（Weaving）、切面（Aspect）这些概念
* 你是如何处理内存泄露或者栈溢出问题的
* 你们线上应用的 JVM 参数有哪些
* 怎么提升系统的QPS和吞吐量

## 知识面
* 解释什么是 MESI 协议(缓存
* 一致性)
* 谈谈 reactor 模型
* Java 9 带来了怎样的新功能
* Java 与 C++ 对比，C++ 或 Java 中的异常处理机制的简单原理和应用
* 简单讲讲 Tomcat 结构，以及其类加载器流程
* 虚拟内存是什么
* 阐述下 SOLID 原则
* 请简要讲一下你对测试驱动开发（TDD）的认识
* CDN实现原理
* Maven 和 ANT 有什么区别
* UML中有哪些常用的图
* Linux
    * Linux 下 IO 模型有几种，各自的含义是什么。
    * Linux 系统下你关注过哪些内核参数，说说你知道的
    * Linux 下用一行命令查看文件的最后五行
    * 平时用到哪些 Linux 命令
    * 用一行命令输出正在运行的 Java 进程
    * 使用什么命令来确定是否有 Tomcat 实例运行在机器上
* 什么是 N+1 难题
* 什么是 paxos 算法
* 什么是 restful，讲讲你理解的 restful
* 什么是 zab 协议
* 什么是领域模型(domain model)？贫血模型(anaemic domain model) 和充血模型(rich domain model)有什么区别
* 什么是领域驱动开发（Domain Driven Development）
* 介绍一下了解的 Java 领域的 Web Service 框架
* Web Server、Web Container 与 Application Server 的区别是什么
* 微服务（MicroServices）与巨石型应用（Monolithic Applications）之间的区别在哪里
* 描述 Cookie 和 Session 的作用，区别和各自的应用范围，Session工作原理
* 你常用的持续集成（Continuous Integration）、静态代码分析（Static Code Analysis）工具有哪些
* 简述下数据库正则化（Normalizations）
* KISS,DRY,YAGNI 等原则是什么含义
* 分布式事务的原理，优缺点，如何使用分布式事务？
* 布式集群下如何做到唯一序列号
* 网络
    * HTTPS 的加密方式是什么，讲讲整个加密解密流程
    * HTTPS和HTTP的区别
    * HTTP连接池实现原理
    * HTTP集群方案
    * Nginx、lighttpd、Apache三大主流 Web服务器的区别
* 是否看过框架的一些代码
* 持久层设计要考虑的问题有哪些？你用过的持久层框架有哪些
* 数值提升是什么
* 你能解释一下里氏替换原则吗
* 你是如何测试一个应用的？知道哪些测试框架
* 传输层常见编程协议有哪些？并说出各自的特点

## 编程题
### 计算加班费
加班10小时以下加班费是时薪的1.5倍。加班10小时或以上，按4元/时算。提示：（一个月工作26天，一天正常工作8小时）
*  计算1000月薪，加班9小时的加班费 
* 计算2500月薪，加班11小时的加班费
* 计算1000月薪，加班15小时的加班费

### 卖东西
一家商场有红苹果和青苹果出售。（红苹果5元/个，青苹果4元/个）。
* 模拟一个进货。红苹果跟青苹果各进200个。
* 模拟一个出售。红苹果跟青苹果各买出10个。每卖出一个苹果需要进行统计。

提示：一个苹果是一个单独的实体。

### 日期提取
有这样一个时间字符串：2008-8-8 20:08:08 ， 请编写能够匹配它的正则表达式，并编写Java代码将日期后面的时分秒提取出来，即：20:08:08

### 线程
* 8设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。
* 用Java写一个多线程程序，如写四个线程，二个加1，二个对一个变量减一，输出
* wait-notify 写一段代码来解决生产者-消费者问题

### 数字
* 判断101-200之间有多少个素数，并输出所有素数
```java
	//求素数质数 只能被1和自己本身整除
	public static List<Integer> getPrime(int start, int end){
		if(start <=0 || end <= 0 || start > end) throw new RuntimeException();
		List<Integer> result = new ArrayList<>();
		for(int i = start; i<= end; i++){
			int j = 2;
			while(j < i){
				if(i%j == 0) break;
				j++;
			}
			if(i == j) result.add(i);
		}
		return result;
	}
```
* 用最有效率的方法算出2乘以17等于多少
答：System.out.println(17<<1);
* 有 1 亿个数字，其中有 2 个是重复的，快速找到它，时间和空间要最优
* 2 亿个随机生成的无序整数,找出中间大小的值
* 10 亿个数字里里面找最小的 10 个
答：topk 问题(https://www.tuicool.com/articles/iUV3An)
* 1到1亿的自然数，求所有数的拆分后的数字之和，如286 拆分成2、8、6，如1到11拆分后的数字之和 => 1 + ... + 9 + 1 + 0 + 1 + 1
* 一个数如果恰好等于它的因子之和，这个数就称为 “完数 “。例如6=1＋2＋3.编程   找出1000以内的所有完数
* 一个数组中所有的元素都出现了三次，只有一个元素出现了一次找到这个元素 
* 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？ 
* 求100－1000内质数的和
* 求1到100的和的平均数
* 求s=a+a+aaa+aaaa+aa…a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 求出1到100的和
* 算出1到40的质数，放进数组里
    *  显示放组里的数
    *  找出第[5]个数
    *  删除第[9]个数，再显示删除后的第[9]个
* 有 3n+1 个数字，其中 3n 个中是重复的，只有 1 个是不重复的，怎么找出来。
* 有一组数1.1.2.3.5.8.13.21.34。写出程序随便输入一个数就能给出和前一组数字同规律的头5个数
* 计算指定数字的阶乘
```java
	public static int fact(int n){
		if(n == 0) return 1;
			return n*fact(n-1);
	}
```
* 开发 Fizz Buzz 
* 给定一个包含 N 个整数的数组，找出丢失的整数
* 一个排好序的数组，找出两数之和为m的所有组合 
* 将一个正整数分解质因数。例如：输入90,打印出90=2\*3\*3\*5。
* 打印出所有的 “水仙花数 “，所谓 “水仙花数 “是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 “水仙花数 “，因为153=1的三次方＋5的三次方＋3的三次方
* 原地交换两个变量的值

method1: A=A+B; B=A-B;A=A-B
method2:A=A^B;B=A^B;A=A^B;
* 找出4字节整数的中位数
* 找到整数的平方根

```java
		//二分法
	public static double sqrt(double target, Double prec){
		if (target < 0) {
			throw new RuntimeException();
		}
		double precise = (prec != null ? prec : 1e-7);  
		double low = 0, high = target, middle = 0, squre = 0;
		while(high-low > precise){
			middle = (high + low)/2;
			squre = middle * middle;
			if (squre < target)
				low = middle;
			if(squre > target)
				high = middle;
		}
		return (high + low)/2;
	}
	//newton
	public static double sqrt1(double target, Double prec){
		if (target < 0) {
			throw new RuntimeException();
		}
		double precise = (prec != null ? prec : 1e-7);
		double x = target;
		while (x*x - target > precise) {
			x = (x + target/x)/2;
		}
		return x;
	}
	
```
* 实现斐波那契

```java
	public static int Fibnacci0(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		return Fibnacci0(number-1) + Fibnacci0(number-2);
		
	}
	public static int Fibnacci1(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		int a = 1, b = 1, c = 0;
		for(int i = 3; i <= number; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	public static int Fibnacci2(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		int[] array = new int[number + 1];
		array[0] = 0; array[1] = 1; array[2] = 1;
		for(int i = 3; i <= number; i++){
			 array[i] = array[i-1] + array[i-2];
		}
		return array[number];
	}
```

### 网络
* 用Java Socket编程，读服务器几个字符，再写入本地显示

## 反射
* 反射机制提供了什么功能？
* 反射是如何实现的
* 哪里用到反射机制
* 反射中 Class.forName 和 ClassLoader 区别
* 反射创建类实例的三种方式是什么
* 如何通过反射调用对象的方法
* 如何通过反射获取和设置对象私有字段的值
* 反射机制的优缺点

### 数据库
* 写一段 JDBC 连Oracle的程序,并实现数据查询

### 算法
* 50个人围坐一圈，当数到三或者三的倍数出圈，问剩下的人是谁，原来的位置是多少
* 实现一个电梯模拟器用
* 写一个冒泡排序
	```java
		public static int[] sort(int[] array){
		int[] newarray = null;
		for(int i = 0; i <= array.length - 1; i++){
			for(int j = i + 1; j <= array.length - 1; j++){
				if(array[i] > array[j]){
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		newarray = array;
		return newarray;
	}
	```
* 写一个折半查找
	```java
	public static boolean find(int[] array, int target){
		int start = 0;
		int end = array.length-1;
		while(start <= end){
			int middle = (start + end)/2;
			if(target == array[middle]){
				return true;
			}
			else if(target < array[middle]){
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		return false;
	}
	```
	
* 随机产生20个不能重复的字符并排序
    
    ```java
    package com.sdt.randomstring;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;
    import java.util.Random;
    import java.util.Set;
    import java.util.TreeSet;
    /**
     * 随机产生20个字符串并且字符串不能重复 且进行排序 
     * @author liuqiang
     *
     */
    public class RandomDemo {

        /**
         * @param args
         */
        public static String getString(int n) {
            String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
            Random ran = new Random();  
            char[] ca = new char[n];
            for (int i = 0; i < ca.length; i++) {  
                ca[i] = s.charAt(ran.nextInt(62));  
            }  
            return new String(ca);  
        }
        //treeset本身就有排序和去重作用
        public static String[] getStrings(int n){
            String[] myStrings = new String[n];
            Set stringset = new TreeSet();
            while(stringset.size() < n){
                stringset.add(getString(10));
            }
            Object[] strings = stringset.toArray();
            for(int i = 0; i < strings.length; i++){
                myStrings[i] = (String)strings[i];
            }
            return myStrings;
        }
        public static void main(String[] args) {
            String[] sa = getStrings(100);   
            for (int i = 0; i < sa.length; i++) {  
             System.out.println(sa[i]);  
            }  

        }

    }
        public static void main(String[] args) {
            // 随机产生20个字符并且字符不能重复 且进行排序 
            Set noreapeat  =new TreeSet();
            Random rdm = new Random();  
            while (noreapeat.size()<20){
                int  bb =Math.abs(rdm.nextInt())%26+97;
                char cc =(char)bb;
                noreapeat.add(cc);
           }
           System.out.println(noreapeat);
        }
    ```
* 写一个函数，传入 2 个有序的整数数组，返回一个有序的整数数组

    ```java
    public static int[] combine(int[] a, int[] b){
            int lena = a.length;
            int lenb = b.length;
            int i = 0, j = 0, k = 0;
            int[] c = new int[lena + lenb];
            while(i < lena && j < lenb){
                if (a[i] < b[j]) {
                    c[k++] = a[i++];
                }
                else{
                    c[k++] = b[j++];
                }
            }
            while(i < lena){c[k++] = a[i++];}
            while(j < lenb){c[k++] = b[j++];}
            return c;
        }
    ```
* 写一段代码在遍历 ArrayList 时移除一个元素
    http://swiftlet.net/archives/743
    ```java
		public static void remove1(ArrayList<String> list){
		for(int i = list.size() - 1; i >= 0; i--){
			String string = list.get(i);
			if("b".equals(string)){
				list.remove(string);
			}
		}
	}
	public static void remove2(ArrayList<String> list){
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string = iterator.next();
			if("b".equals(string)){
				iterator.remove();
			}
		}
	}
    ```
* 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少
* 约瑟芬环游戏

### 正则
* 请编写一段匹配IP地址的正则表达式
	```java
    public final static String DOT = "\\.";
	public static boolean validate(String ip){
		if(ip == null || ip.equals(""))
			return false;
		String[] parts = ip.split(DOT);
		if (parts.length != 4) 
			return false;
		for(String part : parts){
			try {
				if(Integer.parseInt(part) < 0 || Integer.parseInt(part)> 255)
					return false;
			} catch (Exception e) {
				return false;
			}
			
		}
		return true;
	}
    ```
* 写出一个正则表达式来判断一个字符串是否是一个数字

### 字符串
* 写一个方法，入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
* 写一个程序找出所有字符串的组合，并检查它们是否是回文串
* 写一个字符串反转函数，输入abcde转换成edcba代码
    http://blog.csdn.net/guomutian911/article/details/48912617
    ```java
		public static String convert(String origin){
            StringBuilder ret = new StringBuilder();
                for(int i = origin.length() -1; i >= 0; i--){
                    ret.append(origin.charAt(i));
                }
            return ret.toString();
		}
    ```
* 小游戏，倒转句子中的单词
* 将GB2312编码的字符串转换为ISO-8859-1编码的字符串
* 请写一段代码来计算给定文本内字符“A”的个数。分别用迭代和递归两种方式
* 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”
* 给定 2 个包含单词列表（每行一个）的文件，编程列出交集
* 打印出一个字符串的所有排列
* 将一个键盘输入的数字转化成中文输出(例如：输入1234567，输出:一百二拾三万四千五百六拾七)
* 在Web应用开发过程中经常遇到输出某种编码的字符，如从 GBK 到 ISO8859-1等，如何输出一个某种编码的字符串

## 日期
* 计算两个日期之间的差距

## 缓存
* LRU算法
答： https://www.cnblogs.com/springfor/p/3869393.html
http://flychao88.iteye.com/blog/1977653

方法1 直接使用java的linkedhashmap，可以指定accessorder，重写removeEldestEntry即可。
方法2 使用双链表+map
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.