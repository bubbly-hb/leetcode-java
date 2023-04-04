# String类
- int indexOf(int ch)  
返回指定字符在此字符串中第一次出现处的索引。
- int indexOf(int ch, int fromIndex)  
返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
- int indexOf(String str)  
返回指定子字符串在此字符串中第一次出现处的索引。
- int indexOf(String str, int fromIndex)  
返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
- String toLowerCase()  
使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
- char charAt(int index)  
返回指定索引处的 char 值。
- String substring(int beginIndex)  
返回一个新的字符串，它是此字符串的一个子字符串。
- String substring(int beginIndex, int endIndex)  
返回一个新字符串，它是此字符串的一个子字符串。
- String replaceAll(String regex, String replacement)  
使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
- String replaceFirst(String regex, String replacement)  
使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

# [StringBuffer](https://www.runoob.com/java/java-stringbuffer.html)
- StringBuilder不是线程安全但有速度优势，StringBuffer线程安全。
- 回溯时常用toString()、append()、deleteCharAt()方法。删除末尾元素为 a.deleteCharAt(a.length() - 1);