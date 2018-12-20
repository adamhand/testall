package GenericArray;

public class GenericArray<T> {
    private Object[] values;

    GenericArray(int count){
        values = new Object[count];
    }

    public void setValue(T t, int position){
        values[position] = t;
    }

    public T getValue(int positioin){
        return (T)values[positioin];
    }

    public T[] getValues(){
        return (T[]) values;
    }
}
