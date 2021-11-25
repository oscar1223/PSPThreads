
public class MyHilo extends Thread{
    private SolicutarSuspender suspender = new SolicitarSuspender();

    public  void Supender(){suspender.set(true);}
    public void Reanudar(){suspender.set(false);}

    public void run(){
        try{
            while(){
                suspender.esperandoParaReanudar();
            }
        }catch(InterruptedException exception){
            System.out.println("Error");
        }
    }



}
