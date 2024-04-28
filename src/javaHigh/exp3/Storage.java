package javaHigh.exp3;

import java.util.ArrayList;

/**
 * @author guiyi
 * @Date 2024/4/28 下午5:26:46
 * @ClassName javaHigh.exp3.Storage
 * @function -->实现了接口 IStorage，用于存储单个元素并提供根据索引检索元素的功能。内部使用 ArrayList 来存储元素。
 */
public class Storage<E> implements IStorage<E> {
    private final ArrayList<E> items = new ArrayList<E>();

    @Override
    public void store(E item) {
        items.add(item);
    }

    @Override
    public E retrieve(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items.get(index);
    }
}
