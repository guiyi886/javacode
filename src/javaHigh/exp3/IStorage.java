package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午5:02:55
 * @ClassName javaHigh.exp3.IStorage
 * @function -->
 */
public interface IStorage<E> {
    void store(E item);

    E retrieve(int index);
}
