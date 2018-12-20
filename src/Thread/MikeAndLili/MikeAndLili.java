package Thread.MikeAndLili;

/**
 * Mike and Lili的例子
 */
class Resource
{
    String name;
    //int age;
    String sex;
}

class Input implements Runnable
{
    Resource r;

    public Input(Resource r)
    {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true)
        {
            synchronized (r)
            {
                if(x == 0)
                {
                    r.name = "Mike";
                    r.sex = "man";
                }
                else
                {
                    r.name = "丽丽";
                    r.sex = "女";
                }
            }
            x = (x + 1) % 2;
        }
    }
}

class Output implements Runnable
{
    Resource r;

    public Output(Resource r)
    {
        this.r = r;
    }

    @Override
    public void run() {
        while(true)
        {
            synchronized (r)
            {
                System.out.println(r.name+".........."+r.sex);
            }
        }
    }
}

public class MikeAndLili {
    public static void main(String[] args) {
        Resource r = new Resource();

        Input in = new Input(r);
        Output out = new Output(r);

        Thread t0 = new Thread(in);
        Thread t1 = new Thread(out);

        t0.start();
        t1.start();
    }
}
