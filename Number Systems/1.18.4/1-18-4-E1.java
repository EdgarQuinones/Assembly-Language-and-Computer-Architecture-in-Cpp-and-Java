class E1 {
    
    public static void main(String[] args) {
        
        float sum = 0.0f, z = 0.001f;
        for (int i = 1; i <= 1000; i++) 
            sum = sum + z;
        System.out.println("sum = "+sum); // You would think it would equal 1, but it does not!

    }

}

