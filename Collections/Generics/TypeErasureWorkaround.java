public class TypeErasureWorkaround<T> {
    private Class<T> typeToken;

    public TypeErasureWorkaround(Class<T> typeToken) {
        this.typeToken = typeToken;
    }

    public boolean isInstance(Object obj) {
        return typeToken.isInstance(obj); 
    }
}