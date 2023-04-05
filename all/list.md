# List
导入 java.util.List 包才能使用List  
## 实现List的类
这些类在Collections框架中定义并实现List接口。  
- 数组列表（ArrayList类）
- 链表（LinkedList类）
- 向量（vector类）
- 堆栈（Stack类）
## List方法
List接口包括Collection接口的所有方法。 这是因为Collection是List的超级接口。  
Collection接口中还提供了一些常用的List接口方法：  
- add() - 将元素添加到列表
- addAll() - 将一个列表的所有元素添加到另一个
- get() - 有助于从列表中随机访问元素
- iterator() - 返回迭代器对象，该对象可用于顺序访问列表的元素
- set() - 更改列表的元素
- remove() - 从列表中删除一个元素
- removeAll() - 从列表中删除所有元素
- clear() - 从列表中删除所有元素（比removeAll()效率更高）
- size() - 返回列表的长度
- toArray() - 将列表转换为数组
- contains() -  如果列表包含指定的元素，则返回true
## List与Set
- List接口和Set接口都继承了Collection接口。 但是，它们之间存在一些差异。
- List可以包含重复的元素。但是，Set不能有重复的元素。
- List中的元素以某种顺序存储。但是，Set中的元素以组的形式存储，就像数学中的集合一样。

