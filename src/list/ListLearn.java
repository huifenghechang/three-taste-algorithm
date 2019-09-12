package list;

import java.util.ArrayList;
import java.util.List;

/*
* 值传递与引用传递
* */

/*
* List列表中，存储的元素分为两种：
    - 一种是可变元素，如List,Map,自定义的类等。
    - 另一种是不可变元素，如String类型时。

   Add()方法，是将传入的参数，作为当前List中的一个item存储。
   即是传入一个List,也只会另当前的List增加一个元素。

   AddAll()传入的是一个List，将此List中的所有元素都加入到当前的List中，
   此时，增加的元素的大小，即为传入的list的大小。

   AddAll（）方法，复制的是被添加列表的元素的引用，
            本质上只是复制了元素的引用，没有复制元素本身。

  调用L1.addAll(L2)为例，
  如果列表里元素为不可变元素（例String）类型时，对L2列表内元素进行更改不会影响到L1，
        因为String类型本身并不能被修改，对元素的修改本质上都是修改元素引用，而引用是互不影响的。

  如果列表内元素为可变元素（例如List、Map）类型，对列表L2内用用的元素的修改是会影响到L1的，
        因为只复制了引用，而引用指向的是同样的元素。


* */
public class ListLearn {
    public static void main(String[] args){
//        list1AddList2Invariable();
//        list1AddList2Variable();
        list1AddList2VariableII();
    }


    // list2 存储不可变元素的情况：
    public static void list1AddList2Invariable(){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list2.add("hello");
        list2.add("world");
        list2.add("MeiTuan");

        list1.addAll(list2);
        System.out.println("list2修改之前");
        System.out.println("list1---"+list1);
        System.out.println("list2---"+list2);
        list2.set(2,"Alibaba");//修改list2中元素的引用
        // 修改list2中元素的引用  list.set(index,value) 与 list.get(index).add()
        System.out.println("list2修改之后");
        System.out.println("list1---"+list1);
        System.out.println("list2---"+list2);
    }

    // list2 存储的是可变的元素的情况
    public static void list1AddList2Variable(){
        List<List<String>> l1 = new ArrayList<List<String>>(); // 创建空l1列表
        List<List<String>> l2 = new ArrayList<List<String>>(); // 创建l2列表

        // 对列表l2进行初始化
        List<String> item1 = new ArrayList<>();
        item1.add("Spring1");
        List<String> item2 = new ArrayList<>();
        item2.add("Spring2");
        List<String> item3 = new ArrayList<>();
        item3.add("Spring3");
        l2.add(item1);l2.add(item2);l2.add(item3);

        // 执行List1.AddAll(list2)
        l1.addAll(l2);
        System.out.println("before list2 change");
        System.out.println("List1"+l1);
        System.out.println("List2"+l2);

        l2.get(1).set(0,"Spring001");// 修改l2中的元素进行修改
        System.out.println("After list2 change");
        System.out.println("List1"+l1);
        System.out.println("List2"+l2);
    }
    public static void list1AddList2VariableII(){
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        // 对list2进行初始化
        for(int i=0;i<6;i++){
            list2.add(new Node(i+1));
        }
        // 执行list1.addAll(list2)
        list1.addAll(list2);
        // 在修改之前
        System.out.println("before data change");
        System.out.println(list1.get(1).getValue());
        System.out.println(list2.get(1).getValue());
        // 对list2进行修改
        list2.get(1).setValue(888); // 对引用进行修改
        System.out.println("After data change");
        System.out.println(list1.get(1).getValue());
        System.out.println(list2.get(1).getValue());
    }

    static class Node{
        int value;

        public int getValue(){
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }

        public Node(int value){
            this.value = value;
        }
    }

}
