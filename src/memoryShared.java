public class memoryShared {

    private int Thread;

    //constructeur
    private memoryShared()
    {
        this.Thread = 1;
    }

    //getter
    public int getThread(){
        return Thread;
    }
    //setter
    public void setThread(){
        this.Thread++;
    }

    private static memoryShared Inst = null;

    //Unique instance
    public static synchronized memoryShared getInstance()
    {
        if (Inst == null)
        {   Inst = new memoryShared();
        }
        return Inst;
    }
}
