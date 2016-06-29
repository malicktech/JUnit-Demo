package com.agilidee.livrejunit.math;

public class PPCMImpl {
    public Long calculer(Long a, Long b) {
        Long A=a;
        Long B=b;
        while (A!=B)
        {
            if (A > B)
                B = B + b;
            else
                A = A + a;
        }
        return A;
    }
}
