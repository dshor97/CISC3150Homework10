public abstract class myPlugin {
    public void whoSaysHello(){}
    public void whoSaysBye(){}
}class plugin1 extends myPlugin{    public void whoSaysHello(){        System.out.println("plugin1 says hello.");    }    public void whoSaysBye(){ System.out.println("plugin1 says bye."); }}