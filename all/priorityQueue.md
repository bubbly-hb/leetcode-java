# [priorityQueue](https://www.cainiaojc.com/java/java-priorityqueue.html)
- add() - 将指定的元素插入队列。如果队列已满，则会引发异常。
- offer() - 将指定的元素插入队列。如果队列已满，则返回false。
- peek() - 此方法返回队列的头部.
- remove() - 从队列中删除指定的元素. 如果队列中存在多个元素，则只会删除一个，比如 [4, 5, 4] remove(4) 后为 [4, 5].
- poll() - 返回并删除队列的开头.
- contains(element)	- 在优先级队列中搜索指定的元素。如果找到该元素，则返回true，否则返回false。
- size() - 返回优先级队列的长度。
- toArray() - 将优先级队列转换为数组，并返回它。
- isEmpty() - 是否为空
- 自定义类指定排序方式：
  - 可以声明一个类 a 实现 Comparable<a>,并在类中实现compareTo方法，如：
    ```java
    class node implements Comparable<node> {
        ListNode v;
        node(ListNode v) {
            this.v = v;
        }
        public int compareTo(node a) {
            return this.v.val - a.v.val;
        }
    }
    PriorityQueue<node> q = new PriorityQueue<>();
    ```
  - 或者在声明q时直接指定，如：
    ```java
    PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
    ```
- 经典题目 - [合并k个排序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)：
    ```java
    class Solution {
        class node implements Comparable<node> {
            ListNode v;
            node(ListNode v) {
                this.v = v;
            }
            public int compareTo(node a) {
                return this.v.val - a.v.val;
            }
        }
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<node> q = new PriorityQueue<>();
            for (ListNode v : lists) {
                if (v != null) {
                    q.offer(new node(v));
                }
            }
            ListNode dh = new ListNode();
            ListNode trav = dh;
            while(!q.isEmpty()) {
                ListNode t = q.poll().v;
                trav.next = t;
                trav = trav.next;
                if (t.next != null) {
                    q.offer(new node(t.next));
                }
            }
            return dh.next;
        }
    }
    ```
- [天际线问题](https://leetcode.cn/problems/the-skyline-problem/)
    ```java
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();
            List<int[]> a = new ArrayList<>();
            // 预处理所有的点，为了方便排序，对于左端点，令高度为负；对于右端点令高度为正
            for (int[] v : buildings) {
                int l = v[0], r = v[1], h = v[2];
                a.add(new int[]{l, -h});
                a.add(new int[]{r, h});
            }
            Collections.sort(a, (x, y) -> {
                if (x[0] != y[0]) return x[0] - y[0];
                return x[1] - y[1];
            });
            // 大根堆
            PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
            int pre = 0;
            q.offer(0);
            for (int[] v : a) {
                int x = v[0], h = v[1];
                if (h < 0) { // 如果是左端点，说明存在一条往右延伸的可记录的边，将高度存入优先队列
                    h = -h;
                    q.offer(h);
                } else { // 如果是右端点，说明这条边结束了，将当前高度从队列中移除
                    q.remove(h);
                }
                int top = q.peek(); // 取出最高高度，如果当前不与前一矩形“上边”延展而来的那些边重合，则可以被记录
                if (top != pre) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(top);  // 这里不要写成h
                    ans.add(temp);
                    pre = top;
                }
            }
            return ans;
        }
    }
    ```