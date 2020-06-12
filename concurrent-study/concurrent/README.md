# concurrent-demo
并发容器多线程等相关知识
1.使用线程池启动多个线程实现计数器，可以通过锁（reentrantlock,synchronized）,也可以使用原子类AtomicInteger实现同步，volatile只是修改数据可见性与禁止指令重排，并不能保证原子性，因此是线程非安全的
2.Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //迭代每个元素
            String element = iterator.next();
            //删除李四这个元素
            if ("李四".equals(element)) {
                list.remove(element);
                iterator.remove();
            }
        }
   直接使用list.remove会抛出异常，（这个异常是在next方法的checkForComodification中抛出的，抛出原因是modCount != expectedModCount）
  如果想让其不抛出异常，一个办法是让iterator在调用hasNext()方法的时候返回false，这样就不会进到next()方法里了。因此，我们可以删除倒数第二个元素，而不报错。
另一种方法是，使用iterator.remove()因为iterator的remove方法中会强制使modCount = expectedModCount。使用CopyOnWriteArrayList也能保证不抛异常
3.FutureTask的应用实例及类加载过程
