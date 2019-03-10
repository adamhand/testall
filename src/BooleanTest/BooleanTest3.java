package BooleanTest;

class LotsOfBooleans {
    boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class LotsOfInts{
    int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

public class BooleanTest3 {
    private static final int SIZE = 1000000;

    public static void main(String[] args) {
        LotsOfBooleans[] lotsOfBooleans = new LotsOfBooleans[SIZE];
        LotsOfInts[] lotsOfInts = new LotsOfInts[SIZE];

        System.gc();
        long startMemory = getNowMemory();
        for (int i = 0; i < SIZE; i++){
            lotsOfBooleans[i] = new LotsOfBooleans();
        }
        System.gc();
        long stopMemory = getNowMemory();

        System.out.println("size of lotsOfBooleans is : "+ (stopMemory - startMemory));
        System.out.println("average size is : " + (stopMemory - startMemory) / (double)SIZE);

        System.gc();
        startMemory = getNowMemory();
        for (int i = 0; i < SIZE; i++){
            lotsOfInts[i] = new LotsOfInts();
        }
        System.gc();
        stopMemory = getNowMemory();

        System.out.println("size of lotsOfInts is : "+ (stopMemory - startMemory));
        System.out.println("average size is : "+ (stopMemory - startMemory) / (double)SIZE);

        //make sure nothing gets collected
        long total = 0;
        for (int i = 0; i < SIZE; i++){
            total += (lotsOfBooleans[i].a0 ? 1 : 0) + lotsOfInts[i].a0;
        }
        System.out.println(total);
    }

    private static long getNowMemory(){
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
