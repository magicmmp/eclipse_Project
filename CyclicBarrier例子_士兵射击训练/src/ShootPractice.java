/*
��Ȩ������
��Դ��ϵ��Java���̱߳��ʵսָ�ϣ�����ƪ����һ�飨ISBN��978-7-121-31065-2�����³�֮Ϊ��ԭ�顱��������Դ�룬
���˽Ȿ����ĸ���ϸ�ڣ���ο�ԭ�顣
�������Ϊԭ�������˵��֮�ã����������κγ�ŵ����������֤�����棩��
���κ���ʽ��������֮���ֻ���ȫ������Ӫ������;�辭��Ȩ������ͬ�⡣
��������֮���ֻ���ȫ�����ڷ�Ӫ������;��Ҫ�ڴ����б�����������
�κζԱ�������޸����ڴ�������ע�͵���ʽע���޸��ˡ��޸�ʱ���Լ��޸����ݡ�
��������Դ�������ַ���أ�
https://github.com/Viscent/javamtia
http://www.broadview.com.cn/31065
*/

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class ShootPractice 
{
  // ������ѵ����ȫ��ʿ��
  final Soldier[][] rank;
  // �еĸ�������ÿ����ʿ���ĸ���
  final int N;
  // ��г���ʱ�䣨��λ���룩
  final int lasting;
  // ��ʶ�Ƿ�������
  volatile boolean done = false;
  // ����ָʾ������һ�ִ�е�����һ�ŵ�ʿ��
  volatile int nextLine = 0;
  final CyclicBarrier shiftBarrier;
  final CyclicBarrier startBarrier;

  public ShootPractice(int N, final int lineCount, int lasting) 
  {
    this.N = N;
    this.lasting = lasting;
    this.rank = new Soldier[lineCount][N];
    for (int i = 0; i < lineCount; i++) 
    {
      for (int j = 0; j < N; j++) 
      {
        rank[i][j] = new Soldier(i * N + j);
      }
    }
    shiftBarrier = new CyclicBarrier(N, new Runnable() {
      @Override
      public void run() {
        // ������һ�ִ�е���
        nextLine = (nextLine + 1) % lineCount;// ����
        System.out.printf("Next turn is :%d", nextLine);
      }
    });
    // ����
    startBarrier = new CyclicBarrier(N);
  }

  public static void main(String[] args) throws InterruptedException 
  {
    ShootPractice sp = new ShootPractice(4, 5, 24);
    sp.start();
  }

  public void start() throws InterruptedException 
  {
    // �����������������߳�
    Thread[] threads = new Thread[N];
    for (int i = 0; i < N; ++i) 
    {
      threads[i] = new Shooting(i);
      threads[i].start();
    }
    // ָ��ʱ���ֹͣ���
    Thread.sleep(lasting * 1000);
    stop();
    for (Thread t : threads) 
    {
      t.join();//�ȴ����߳�ֹͣ
    }
    System.out.println("Practice finished.");
  }

  public void stop() 
  {
    done = true;
  }

  class Shooting extends Thread 
  {
    final int index;

    public Shooting(int index) 
    {
      this.index = index;
    }

    @Override
    public void run() 
    {
      Soldier soldier;
      try 
      {
        while (!done) 
        {
          soldier = rank[nextLine][index];
          // һ���е�ʿ������ͬʱ��ʼ���
          startBarrier.await();// ����
          // ��ʿ����ʼ���
          soldier.fire();
          // һ���е�ʿ������ȴ������е���������ʿ�������ϲ��ܹ��뿪�����
          shiftBarrier.await();// ����
        }
      } 
      catch (InterruptedException e) 
      {
        // ʲôҲ����
      } 
      catch (BrokenBarrierException e) 
      {
        e.printStackTrace();
      }

    }// run��������
  }// ��Shooting�������

  // ������ѵ����ʿ��
  static class Soldier 
  {
    private final int seqNo;
    int row;
    int col;

    public Soldier(int seqNo) 
    {
      this.seqNo = seqNo;
      row=seqNo/4;
      col=seqNo%4;
    }

    public void fire() 
    {
      System.out.println(this + " start firing...");
      System.out.println(this + " fired.");
    }

    @Override
    public String toString() 
    {
      return row+" �� "+col+" ��  ʿ�������=" + seqNo;
    }

  }// ��Soldier�������
}