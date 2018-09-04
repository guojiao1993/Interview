### 全排列题
这道题不说别的，只说编程基础能力。因为这道题不允许用本地IDE，所以只能手敲代码，出了不少错误。

首先是HashMap的迭代，代码如下：
```java
HashMap<Character, Integer> m = map.get(i);
Iterator<Map.Entry<Character, Integer>> it = m.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Character, Integer> entry = it.next();
    if (entry.getValue() < num) {
        sb.append(entry.getKey());
        break;
    }
}
```
问题来了，Iterator在哪个包里？在 import java.util.Iterator 里，和HashMap一样。

Iterator的next()是什么类型？是 Map.Entry<Character, Integer>。

entry都有什么方法？有getKey()和getValue()。

如何判断HashMap是否包含某个key？是containsKey()。

Scanner在哪个包里？在 java.util.Scanner 中。