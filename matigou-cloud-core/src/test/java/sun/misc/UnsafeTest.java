package sun.misc;

import org.junit.Test;

import java.lang.reflect.Field;

public class UnsafeTest {

    private volatile int state;
    private volatile long state1;

    private static final long stateOffset;
    private static final long stateOffset1;

    private static final Unsafe unsafe = createUnsafe();

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (UnsafeTest.class.getDeclaredField("state"));
            stateOffset1 = unsafe.objectFieldOffset
                    (UnsafeTest.class.getDeclaredField("state1"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    protected final boolean compareAndSetState(int expect, int update) {
        // See below for intrinsics setup to support this
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    public static Unsafe createUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test(){
        System.out.println(state);
        System.out.println(stateOffset);
        System.out.println(state1);
        System.out.println(stateOffset1);

        compareAndSetState(0, 1);

        System.out.println(state);
        System.out.println(stateOffset);
        System.out.println(state1);
        System.out.println(stateOffset1);

    }
}
