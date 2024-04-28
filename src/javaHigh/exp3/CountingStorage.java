package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午5:27:08
 * @ClassName javaHigh.exp3.CountingStorage
 * @function -->继承自 Storage 类，除了继承了父类的存储和检索功能外，还增加了对存储的元素总数进行统计的功能。在存储元素时，同时更新元素总数。
 */
public class CountingStorage<E> extends Storage<E> {
    private int itemCount = 0;

    @Override
    public void store(E item) {
        super.store(item);
        itemCount++;
    }

    public int getItemCount() {
        return itemCount;
    }

}
