package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午6:07:45
 * @ClassName javaHigh.exp3.CountingStorageWithForwarding
 * @function -->实现了接口 IStorage，不继承自 Storage 类，而是内部持有一个 Storage 实例来存储元素。
 * 提供了与 CountingStorage 相同的公共接口，并使用转发的方式来实现存储和检索方法。
 * 同时维护一个元素总数计数，更新和提供当前存储的元素总数。
 */
public class CountingStorageWithForwarding<E> implements IStorage<E> {
    private final Storage<E> storage = new Storage<>();
    private int itemCount = 0;

    @Override
    public void store(E item) {
        storage.store(item);
        itemCount++;
    }

    @Override
    public E retrieve(int index) {
        return storage.retrieve(index);
    }

    public int getItemCount() {
        return itemCount;
    }
}
