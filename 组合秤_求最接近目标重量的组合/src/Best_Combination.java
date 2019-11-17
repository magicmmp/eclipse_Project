import java.util.Random;

public class Best_Combination {

	public static void init_hopper_weights(float array[] ,int arrayLength,float target_weight)
	{
		int i;
		float D_ratio=(float)0.5;
		float hopper_weight=target_weight*3/arrayLength;//期望参与组合的斗是总斗数的三分一
		float D_value=hopper_weight*D_ratio;
		for(i=0;i<arrayLength;i++)		
		{
			Random random = new Random();
			float f=random.nextFloat();//产生0到1之间均匀分布的小数
			array[i]=hopper_weight-D_value+D_value*2*f;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nHoppers=15;//有几个斗
		float[] weights=new float[nHoppers];//每个斗的重量
		float target_weight=100;//目标重量
		float target_weight_min=95;//目标重量下限
		float target_weight_max=105;//目标重量上限
		
		init_hopper_weights(weights,weights.length,target_weight);
		
		for(int i=0;i<weights.length;i++)
			System.out.print(weights[i]+" ");
		
		
		
		
		

	}

}
