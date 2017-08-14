package list.src;

public interface HList<E> {

	int size();
    boolean isEmpty();

	void add(E e);
	void addAt(E e, int i);

	E remove();
	E remove(int index);
	E remove(E e);

	E get();
	E get(int index);

	void swap(int i1, int i2);
}
