package com.arithmetic.littlemath;

public class Meeting {
    public static void main(String[] args)
    {
        method mt=new method();
        mt.display();
    }

}
class method
{

    public int countGo(int ... as)
    {
        int sum=0;
        for(int a : as)
        {
            if(a==1)
                sum++;
        }
        return sum;
    }
    public boolean tm1(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a1,a2)>0)
        {
            return true;
        }
        return false;
    }
    public boolean tm2(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a1,a5,a6)==2)
        {
            return true;
        }
        return false;
    }
    public boolean tm3(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a2,a3)==0||countGo(a2,a3)==2)
        {
            return true;
        }
        return false;
    }
    public boolean tm4(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a1,a4)==1)
        {
            return true;
        }
        return false;
    }
    public boolean tm5(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a3,a4)==1)
        {
            return true;
        }
        return false;
    }
    public boolean tm6(int a1,int a2,int a3,int a4,int a5,int a6)
    {
        if(countGo(a4)==0)
        {
            if(countGo(a5)==0)
                return true;
        }else{
            return false;
        }
        return true;
    }
    public void display()
    {
        for(int A=0;A<=1;A++)
            for(int B=0;B<=1;B++)
                for(int C=0;C<=1;C++)
                    for(int D=0;D<=1;D++)
                        for(int E=0;E<=1;E++)
                            for(int F=0;F<=1;F++)
                            {
                                if(tm1(A,B,C,D,E,F)
                                        &&tm2(A,B,C,D,E,F)
                                        &&tm3(A,B,C,D,E,F)
                                        &&tm4( A,B,C,D,E,F)
                                        &&tm5( A,B,C,D,E,F)
                                        &&tm6( A,B,C,D,E,F)
                                )
                                {
                                    System.out.println("A="+A+",B="+B+",C="+C+
                                            ",D="+D+",E="+E+",F="+F);
                                }
                            }

    }
}