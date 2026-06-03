package uz.ds;

public class CustomArray<T> {

    private Object[] array;

    /**
     * Default holatda size 10 ga teng bo'ladi
     * Agar size == defaultCapacity shart bajarilsa array uzunligini
     * 1.5x barobar kattalashadi
     * */
    private int defaultCapacity = 10;
    private int size = 0;

    public CustomArray(int capacity) {
        this.defaultCapacity = capacity;
        this.array = new Object[defaultCapacity];
    }

    public CustomArray() {
        this.array = new Object[this.defaultCapacity];
    }

    public T add(T elemnt) {
        resize();
        array[size++] = elemnt;
        return elemnt;
    }

    public T add(T elemnt, int index) {
        indexCheck(index);
        resize();

        if (index == size) {
            array[size++] = elemnt;
            return elemnt;
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = elemnt;
        size++;
        return elemnt;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        indexCheck(index);
        return (T) array[index];
    }

    public void remove(int index) {
        indexCheck(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    private void resize() {
        if (this.size == this.defaultCapacity) {
            Object[] newArray = calculateNewCapacityAndGetArray();
            copyArray(newArray);

            this.defaultCapacity = newArray.length;
            this.array = newArray;
        }
    }

    private Object[] calculateNewCapacityAndGetArray() {
        int newCapacity = (int) (defaultCapacity * 1.5);
        return new Object[newCapacity];
    }

    private void copyArray(Object[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
    }

    private void indexCheck(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Index ex!");
    }


    public int size() {
        return this.size;
    }
}
