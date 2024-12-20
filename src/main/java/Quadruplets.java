import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class Quadruplets implements Iterable<Quadruple> {
    LinkedList<Quadruple> quads = new LinkedList<>();
    public int addQuad(String s1,String s2,String s3,String s4)
    {
        return addQuad(new Quadruple(s1,s2,s3,s4));
    }

    public int addQuad(Quadruple quad)
    {
        quads.add(quad);
        return quads.size()-1;
    }

    public Quadruple getQuad(int index)
    {
        return quads.get(index-1);
    }

    public int size()
    {
        return quads.size();
    }


    public Quadruple getQuads(int index) {
        return quads.get(index);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Quadruple> iterator() {
        return quads.iterator();
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super Quadruple> action) {
        Iterable.super.forEach(action);
    }
}
